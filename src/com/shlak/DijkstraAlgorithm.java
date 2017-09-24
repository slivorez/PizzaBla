package com.shlak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.fill;

    public class DijkstraAlgorithm {

        StreetMap streetMap = new StreetMap();
        private int INF = Integer.MAX_VALUE / 2; // "Бесконечность"
        private int vNum; // количество вершин
        private int[][] graph; // матрица смежности

        public DijkstraAlgorithm(int vNum, int[][] graph) {
            this.vNum = vNum;
            this.graph = graph;
        }

        public int[] dijkstra(int start) {
            boolean[] used = new boolean[vNum]; // массив пометок
            int[] dist = new int[vNum]; // массив расстояния. dist[v] = минимальное_расстояние(start, v)

            fill(dist, INF); // устанаавливаем расстояние до всех вершин INF
            dist[start] = 0;// для начальной вершины положим 0

            for (; ; ) {
                int v = -1;
                for (int nv = 0; nv < vNum; nv++) // перебираем вершины
                    if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv])) // выбираем самую близкую непомеченную вершину
                        v = nv;
                if (v == -1) break; // ближайшая вершина не найдена
                used[v] = true; // помечаем ее
                for (int nv = 0; nv < vNum; nv++)
                    if (!used[nv] && graph[v][nv] < INF) // для всех непомеченных смежных
                        dist[nv] = min(dist[nv], dist[v] + graph[v][nv]); // улучшаем оценку расстояния (релаксация)
            }
            return dist;
        }
    }

