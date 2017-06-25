package com.github.j5ik2o.scalatest.db

import com.wix.mysql.EmbeddedMysql
import org.scalatest.{ FreeSpec, MustMatchers }

class WixMySQLOnInstancePerFreeSpec extends FreeSpec with MustMatchers with WixMySQLOneInstancePerSuite {

  override val schemaConfigs: Seq[SchemaConfig] = Seq(SchemaConfig("test"))

  var mysqld: EmbeddedMysql = _

  "WixMySQLOnInstancePerFreeSpec" - {
    "should start & stop mysqld1" in {
      println(s"context = $wixMySQLContext")
      wixMySQLContext mustNot be(null)
      wixMySQLContext.schemaConfigs.head.name mustBe "test"
      mysqld = wixMySQLContext.embeddedMysql
    }
    "should start & stop mysqld2" in {
      println(s"context = $wixMySQLContext")
      wixMySQLContext mustNot be(null)
      wixMySQLContext.schemaConfigs.head.name mustBe "test"
      wixMySQLContext.embeddedMysql mustBe mysqld
    }
  }

}
