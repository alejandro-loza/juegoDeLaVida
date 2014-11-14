package com.celulas

import org.junit.Ignore
import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: pinky
 * Date: 11/13/14
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
class CelulasSpec extends Specification{


//    @Ignore
    void "must create a file"(){
        setup:
          Celulas celulas = new Celulas()
        def myFileName = "input.txt"
        def myFile = new File(myFileName)
        when:
          def response = celulas.creaArchivo(myFile)
        then:
          assert response instanceof File

    }

//    @Ignore
    void "must open a file"(){
        setup:
        Celulas celulas = new Celulas()
        def myFileName = "input.txt"
        def myFile = new File(myFileName)
        myFile
        when:
        def response = celulas.leeArchivo(myFile)
        then:
        assert response == ['.........*', '.*.*...*..', '..........', '..*.*....*', '.*..*...*.', '.........*','..........' , '.....*..*.', '.*....*...', '.....**...']

    }
//    @Ignore
    void "must open a file and if it doesn exist create it"(){
        setup:
        Celulas celulas = new Celulas()
        when:
        def response = celulas.obtenArchivo()
        then:
        assert response
    }
    void "must read input and print it"(){
        setup:
        Celulas celulas = new Celulas()
        when:
        def response = celulas.inicio()
        then:
        assert response
    }

    void "must buffer it in a matrix"(){
        setup:
          List<String> lines = ['.........*', '.*.*...*..', '..........', '..*.*....*', '.*..*...*.', '.........*','..........' , '.....*..*.', '.*....*...', '.....**...']
          Celulas celulas = new Celulas()
        when:
          def response = celulas.holdInMatrix(lines)
        then:
          assert response
    }

    void "given a matrix must  find its partners"(){
        setup:"given a string matrix"
          String[][] matrix = ['.........*', '.*.*...*..', '..........', '..*.*....*', '.*..*...*.', '.........*','..........' , '.....*..*.', '.*....*...', '.....**...']
          Celulas celulas = new Celulas()
        when:
          def response = celulas.siguenteGeneracion(matrix)
        then:
          assert response instanceof String [][]
    }

    void "must search its parteners"(){
        setup: "given 2 numbers"
         def first = 9
         def second = 6
         Celulas celulas = new Celulas()
        when:
        println "busca vecinos"
        def response = celulas.encuentraVecinos(first,second,10)
        then:
        assert response == [[8, 5], [8, 6], [8, 7], [9, 5], [9, 7]]
    }

    void "given a map with index must find  a '*' "(){
        setup:
          String[][] matrix = ['.........*', '.*.*...*..', '..........', '..*.*....*', '.*..*...*.', '.........*','..........' , '.....*..*.', '.*....*...', '.....**...']
          Celulas celulas = new Celulas()
          List<List<Integer>> cordenadas =[[8, 5], [8, 6], [8, 7], [9, 5], [9, 7]]
        when:
          def response = celulas.buscaVivas(matrix,cordenadas)
        then:
          assert response  == 2
    }

    void "Any live cell with one live neighbours dies"(){
        setup:
         Integer vecinosVivios = 1
         Celulas celulas = new Celulas()
         boolean vivo =true
        when:
         def response = celulas.vive(vecinosVivios,vivo)
        then:
          assert !response
    }

    void "Any live cell with cero live neighbours dies"(){
        setup:
          Integer vecinosVivios = 0
          Celulas celulas = new Celulas()
        boolean vivo =true
        when:
          boolean response = celulas.vive(vecinosVivios,vivo)
        then:
         assert !response
    }

    void "Any live cell with two live neighbours lives on to the next generation"(){
        setup:
        Integer vecinosVivios = 2
        Celulas celulas = new Celulas()
        boolean vivo =true
        when:
        boolean response = celulas.vive(vecinosVivios,vivo)
        then:
        assert response
    }

    void "Any live cell with tree live neighbours lives on to the next generation"(){
        setup:
        Integer vecinosVivios = 3
        Celulas celulas = new Celulas()
        boolean vivo =true
        when:
        boolean response = celulas.vive(vecinosVivios,vivo)
        then:
        assert response
    }

    void "Any live cell with more 3 live neighbours lives on to the next generation"(){
        setup:
        Integer vecinosVivios = 4
        Celulas celulas = new Celulas()
        boolean vivo =true
        when:
        boolean response = celulas.vive(vecinosVivios,vivo)
        then:
        assert !response
    }


    void "Any live cell with more 5 live neighbours lives on to the next generation"(){
        setup:
        Integer vecinosVivios = 5
        Celulas celulas = new Celulas()
        boolean vivo =true
        when:
        boolean response = celulas.vive(vecinosVivios,vivo)
        then:
        assert !response
    }

    void "Any live cell with 3 live neighbours lives on to the next generation"(){
        setup:
        Integer vecinosVivios = 3
        Celulas celulas = new Celulas()
        boolean vivo = false
        when:
        boolean response = celulas.vive(vecinosVivios,vivo)
        then:
        assert response
    }

    void "must set the status if recive . *"(){
        setup:
        String original = '*'
        Celulas celulas = new Celulas()
        boolean vivo = false
        when:
        boolean response = celulas.status(original)
        then:
        assert response

    }







}
