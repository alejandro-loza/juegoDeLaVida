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
          assert response
    }

    void "must search its parteners"(){
        setup: "given 2 numbers"
         def first = 0
         def second = 0
        Celulas celulas = new Celulas()
        when:
        def response = celulas.encuentraVecinos(first,second,10)
        then:
        assert response


    }


}
