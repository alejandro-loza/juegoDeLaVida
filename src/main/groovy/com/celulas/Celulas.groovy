package com.celulas

/**
 * Created with IntelliJ IDEA.
 * User: pinky
 * Date: 11/12/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
class Celulas {
    def main(String[] args){
    }


    def  obtenArchivo() {
        def myFileName = "input.txt"
        def myFile = new File(myFileName)
        if(!myFile.exists()){
           creaArchivo(myFile)
        }  else {
            myFile
        }

    }


    File creaArchivo(File myFile) {
      myFile << '.........*\n'
      myFile << '.*.*...*..\n'
      myFile << '..........\n'
      myFile <<'..*.*....*\n'
      myFile <<'.*..*...*.\n'
      myFile <<'.........*\n'
      myFile << '..........\n'
      myFile <<'.....*..*.\n'
      myFile << '.*....*...\n'
      myFile << '.....**...'

      myFile
    }

    def leeArchivo(File file) {
      file.readLines()
    }

    def inicio() {
      File archivo = obtenArchivo()
      def out =leeArchivo(archivo)
      println "ESTADO INICIAL"
      out.each {println it}     //todo imprimir salida con ciclos
      println "SIGUIENTE ESTADO"
      archivo.delete()
    }

    def holdInMatrix(List<String> strings) {
        String[][] matrix = strings as  String [][]
        matrix
    }

    def siguenteGeneracion(String[][] strings) {
        String[][] nextMatrix
         strings.eachWithIndex { row, int i ->
              row.eachWithIndex { col, int j ->
                  encuentraVecinos(i,j,strings.length)
              }
        }


     }

    def encuentraVecinos(int row, int col , int length ) {
       List vecinos = []

        int rowStart  = Math.max( row - 1, 0   )
        int rowFinish = Math.min( row + 1, length - 1 )
        int colStart  = Math.max( col - 1, 0  )
        int colFinish = Math.min( col + 1, length - 1 )

        for ( int curRow = rowStart; curRow <= rowFinish; curRow++ ) {
            for ( int curCol = colStart; curCol <= colFinish; curCol++ ) {
              vecinos << [curRow,curCol]
            }
        }
       println vecinos - [row,col]
        vecinos - [row,col]
    }

    def buscaVivas(String[][] strings, List<Integer> integers) {

    }
}
