package com.github.j5ik2o.scalatest.db

import com.wix.mysql.EmbeddedMysql
import org.scalatest.{ FunSpec, MustMatchers }

class WixMySQLOnInstancePerFunSpec extends FunSpec with MustMatchers with WixMySQLOneInstancePerSuite {

  override val schemaConfigs: Seq[SchemaConfig] = Seq(SchemaConfig("test"))

  var mysqld: EmbeddedMysql = _

  describe("WixMySQLOnInstancePerFunSpec") {
    it("should start & stop mysqld1") {
      println(s"context = $wixMySQLContext")
      wixMySQLContext mustNot be(null)
      wixMySQLContext.schemaConfigs.head.name mustBe "test"
      mysqld = wixMySQLContext.embeddedMysql
    }
    it("should start & stop mysqld2") {
      println(s"context = $wixMySQLContext")
      wixMySQLContext mustNot be(null)
      wixMySQLContext.schemaConfigs.head.name mustBe "test"
      wixMySQLContext.embeddedMysql mustBe mysqld
    }
  }

}
