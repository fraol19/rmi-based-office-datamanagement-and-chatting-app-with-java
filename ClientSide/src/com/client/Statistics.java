package com.client;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import remoteserver.RemoteServerInterface;


public class Statistics {
                        
    private String query;                    
    private RemoteServerInterface server;                      //remote object for method invocation
    private int minyear,maxyear;                               //minimun and maximum Year from the DB tables
    private Map<Integer,Double> statistic;                     //mapped statistics with year as a key
    
    public Statistics(RemoteServerInterface server){ 
       statistic = new HashMap<>();
       this.server = server;
    }

//draws budget statistics 
    public void budgetStatistics() {
        JFrame dialog = createFrame("budget");
        JFXPanel fxpanel = new JFXPanel();
        dialog.add(fxpanel);
        drawChart("Budget and funding statistics of your company", "Year", "Total Budget and Funding in cash", fxpanel,"budget");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               dialog.setVisible(true);
            }
        });
    }

//draws sale statisics    
    public void saleStatistics() {
        JFrame dialog = createFrame("sales");
        JFXPanel fxpanel = new JFXPanel();
        dialog.add(fxpanel);
        drawChart("Total profits and total cost from sales in each year", "Year", "Total Profit and Sales in cash", fxpanel,"sales");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               dialog.setVisible(true);
            }
        });
    }

//draws purchase statistics
    public void buyStatistics() {
        JFrame dialog = createFrame("buy");
        JFXPanel fxpanel = new JFXPanel();
        dialog.add(fxpanel);
        drawChart("Total costs for purchasing", "Year", "Total Purchase in cash", fxpanel,"buy");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               dialog.setVisible(true);
            }
        });
    }

//FrameUI creator    
    public JFrame createFrame(String for_table){
        JFrame dialog = new JFrame();
        dialog.setIconImage(new ImageIcon(getClass().getResource("/icons/chart.png")).getImage());
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialog.setSize(600, 700);
        dialog.setTitle("Statistics");
        dialog.setLocationRelativeTo(null);
        try {
            minyear = server.getMinMaxDate(for_table, 0);
            maxyear = server.getMinMaxDate(for_table, 1);
            statistic = server.getCalculatedData(for_table);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage() + " >> Error cause "+ ex.getCause().toString());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " >> Error cause "+ ex.getCause().toString());
        }

        return dialog;
    }

//Chat drawer based on the fetched data    
    public void drawChart(String title,String xlabe1,String ylabel,JFXPanel fxpanel,String tablename){
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle(title);
        xAxis.setLabel(xlabe1);
        yAxis.setLabel(ylabel);
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series.setName("Cash amount");
        for (int i = minyear; i <= maxyear; i++) {
            if (statistic.containsKey(i)) {
                series.getData().add(new XYChart.Data(String.valueOf(i), statistic.get(i)));
            } else {
                series.getData().add(new XYChart.Data(String.valueOf(i), 0));
            }
        }
        if(tablename.equals("budget")){
            try {
                statistic = server.getExtraStatistics(tablename);
                series2.setName("Funding Cash Amount");
                for (int i = minyear; i <= maxyear; i++) {
                    if (statistic.containsKey(i)) {
                        series2.getData().add(new XYChart.Data(String.valueOf(i), statistic.get(i)));
                    } else {
                        series2.getData().add(new XYChart.Data(String.valueOf(i), 0));
                    }
                }
            } catch (RemoteException ex) {
                System.out.println(ex.getMessage() + " Error cause " + ex.getCause().toString());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + " Error cause " + ex.getCause().toString());
            }
        }
        if(tablename.equals("sales")){
            try {
                statistic = server.getExtraStatistics(tablename);
                series2.setName("Total Sales Cash Amount");
                for (int i = minyear; i <= maxyear; i++) {
                    if (statistic.containsKey(i)) {
                        series2.getData().add(new XYChart.Data(String.valueOf(i), statistic.get(i)));
                    } else {
                        series2.getData().add(new XYChart.Data(String.valueOf(i), 0));
                    }
                }
            } catch (RemoteException ex) {
                System.out.println(ex.getMessage() + " Error cause " + ex.getCause().toString());
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + " Error cause " + ex.getCause().toString());
            }
        }
        if(tablename.equals("budget") || tablename.equals("sales"))
          bc.getData().addAll(series,series2);
        else
          bc.getData().add(series);
        Scene scene = new Scene(bc, 550, 670);
        fxpanel.setScene(scene);
        
    }
    
    
}
