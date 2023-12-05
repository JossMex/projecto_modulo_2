package com.example.projeto2.Tablero;

public class BoardSettings {
    private Board board;
    private Simulation simulation;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public static class Simulation{
        private int duration;
        private int statisticsRefreshInterval;

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getStatisticsRefreshInterval() {
            return statisticsRefreshInterval;
        }

        public void setStatisticsRefreshInterval(int statisticsRefreshInterval) {
            this.statisticsRefreshInterval = statisticsRefreshInterval;
        }
    }

    static class Board{
        private int rows;
        private int columns;

        public int getRows() {
            return rows;
        }

        public void setRows(int rows) {
            this.rows = rows;
        }

        public int getColumns() {
            return columns;
        }

        public void setColumns(int columns) {
            this.columns = columns;
        }
    }
}
