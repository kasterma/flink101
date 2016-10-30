package net.kasterma.flink101

/**
  * Running some basic Table and SQL flows.
  *
  * input.toTable I have not gotten to work yet
  */

import java.io.Serializable

import org.apache.flink.api.common.typeinfo.{BasicTypeInfo, TypeInformation}
import org.apache.flink.api.scala._
import org.apache.flink.api.scala.table._
import org.apache.flink.api.table.{TableEnvironment, Types}
import org.apache.flink.api.table.sources.CsvTableSource


object Table1 {
  def main(args: Array[String]): Unit = {
    case class WC(word: String, count: Int)

    val env = ExecutionEnvironment.getExecutionEnvironment
    val tEnv = TableEnvironment.getTableEnvironment(env)

    val fn: Array[String] = Array("label", "ct")
    val ft: Array[TypeInformation[_]] = Array(Types.STRING, Types.INT)
    val t1 = new CsvTableSource("resources/input.csv", fn, ft)
    tEnv.registerTableSource("mycsv", t1)

    val batchTable = tEnv.scan("mycsv")

    //val input = env.fromElements(WC("hello", 1), WC("hello", 1), WC("ciao", 1))
    //val expr = input.toTable(tEnv)
//    val result = expr
//      .groupBy('word)
//      .select('word, 'count.sum as 'count)
//      .toDataSet[WC]

    //println(input.collect())
//    'a === 'b
//    'a = 'b
    println(batchTable.collect())
    println(batchTable.groupBy('label).select('ct.sum as 'sums, 'label).collect())
    println("hi")
  }

}



