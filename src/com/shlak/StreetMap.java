package com.shlak;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

    public class StreetMap {
        private Map<String, int[]> arr = new HashMap<>();
        private Map<String, Integer> distances;
        private int courierCount;
        private String startPoint;

        public int getCourierCount() {
            return courierCount;
        }

        public void setCourierCount(int courierCount) {
            this.courierCount = courierCount;
        }

        public String getStartPoint() {
            return startPoint;
        }

        public void setStartPoint(String startPoint) {
            this.startPoint = startPoint;
        }

        public Map<String, Integer> getDistances() {
            return distances;
        }

        public void setDistances(Map<String, Integer> distances) {
            this.distances = distances;
        }

        public Map<String, int[]> getArr() {
            return arr;
        }

        public void setArr(Map<String, int[]> arr) {
            this.arr = arr;
        }


        public void adreser() throws FileNotFoundException {

            String[] maxStr = FileWorker.read("Shlak.txt").split("-");
            for (int i = 0; i < maxStr.length; i++) {
                switch (i) {
                    case 0: {
                        arr = trueAddressed(maxStr[i]);
                        break;
                    }
                    case 1: {
                        distances = distance(maxStr[i]);
                        break;
                    }
                    case 2: {
                        maxStr[i] = maxStr[i].replace("\n","");
                        startPoint = maxStr[i];
                        break;
                    }
                    case 3: {
                        maxStr[i] = maxStr[i].replace("\n","");
                        courierCount = Integer.parseInt(maxStr[i]);
                        break;
                    }
                }
            }
        }

        private Map<String, int[]> trueAddressed(String str) {
            String[] array = {"", ""};
            Map<String, int[]> arrer = new HashMap<>();
            String[] arr = str.split("\n");
            String[] tempStr = {"", ""};
            for (String strop : arr
                    ) {
                tempStr = strop.split("p");
                array = tempStr[1].split(" ");
                int[] array1 = new int[2];
                array1[0] = Integer.parseInt(array[0]);
                array1[1] = Integer.parseInt(array[1]);
                arrer.put(tempStr[0], array1);
            }

            return arrer;
        }

        private Map<String, Integer> distance(String str) {

            String[] sstr = str.split("\n");
            Map<String, Integer> distnter = new HashMap<>();
            for (String sss : sstr
                    ) {
                String[] gather = sss.split("g");
                distnter.put(sss.replace("g", " "), vectorLooker(arr.get(gather[1]), arr.get(gather[0])));
            }


            return null;
        }

        private int vectorLooker(int[] first, int[] second) {

            return (int) (Math.sqrt(Math.pow((second[0] - first[0]), 2) + Math.pow((second[1] - first[1]), 2)));

        }

    }
}
