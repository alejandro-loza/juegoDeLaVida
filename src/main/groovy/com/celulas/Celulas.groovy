package com.celulas

/**
 * Created with IntelliJ IDEA.
 * User: pinky
 * Date: 11/12/14
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
class Celulas {
    public static void main(String[] args) {
        inicio()
    }
   static def  obtenArchivo() {
        def myFileName = "input.txt"
        def myFile = new File(myFileName)
        if(!myFile.exists()){
           creaArchivo(myFile)
        }  else {
            myFile
        }
   }

   static File creaArchivo(File myFile) {
      myFile << '.........*\n' +
      '.*.*...*..\n' +
      '..........\n' +
      '..*.*....*\n' +
      '.*..*...*.\n' +
      '.........*\n' +
      '..........\n' +
      '.....*..*.\n' +
      '.*....*...\n' +
      '.....**...'

      myFile
   }

   static def leeArchivo(File file) {
      file.readLines()
    }

   static def inicio() {
      File archivo = obtenArchivo()
      List<String> input =leeArchivo(archivo)
      input.each {println it}
      String [][]iterableMatrix = holdInMatrix(input)
      iterableMatrix = siguenteGeneracion(iterableMatrix)
      def y=0
      10.times{
        println y++
        iterableMatrix.each{
          println  it.join()
        }
        iterableMatrix = siguenteGeneracion(iterableMatrix)
      }
      archivo.delete()
       iterableMatrix
    }

   static def holdInMatrix(List<String> strings) {
       strings as  String [][]
    }

    static String[][] siguenteGeneracion(String[][] matrizEntrada) {
        String[][] newMatrix = new String [matrizEntrada.length][matrizEntrada.length]
        matrizEntrada.eachWithIndex { row, int i ->
              row.eachWithIndex { celula, int j ->
                 if(vive (buscaVivas(matrizEntrada ,encuentraVecinos(i,j,matrizEntrada.length)),status(celula))){
                     newMatrix[i][j]= "*"
                 } else  {
                     newMatrix[i][j]= "."
                 }
              }
        }
        newMatrix
     }

   static def encuentraVecinos(int row, int col , int length ) {
       List vecinos = []

        int rowStart  = Math.max( row - 1, 0   )
        int rowFinish = Math.min( row + 1, length - 1 )
        int colStart  = Math.max( col - 1, 0  )
        int colFinish = Math.min( col + 1, length - 1 )

        for ( int curRow = rowStart; curRow <= rowFinish; curRow++ ) {
            for ( int curCol = colStart; curCol <= colFinish; curCol++ ) {
             if([curRow,curCol] != [row,col]){
                 vecinos << [curRow,curCol]
             }
            }
        }
        vecinos
    }

   static Integer buscaVivas(String[][] matriz, List<List<Integer>> vecinos) {
       def vivas = 0
       vecinos.each { x,y->
           if(matriz[x][y] == "*"){
             vivas++
           }
       }
       vivas
    }

   static def vive(Integer vivos, boolean estatus) {
        if(estatus && vivos in (2..3) ||!estatus && vivos == 3 ){
          true
        }
    }

   static boolean status(String original) {
        original =='*' ?: false
    }
}
