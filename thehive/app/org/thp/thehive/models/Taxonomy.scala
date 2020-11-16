package org.thp.thehive.models

import java.util.Date

import org.thp.scalligraph.models.Entity
import org.thp.scalligraph.{BuildEdgeEntity, BuildVertexEntity, EntityId}

@BuildVertexEntity
case class Taxonomy(
  namespace: String,
  description: String,
  version: Int,
  enabled: Boolean
)

@BuildEdgeEntity[Taxonomy, Tag]
case class TaxonomyTag()

case class RichTaxonomy(
  taxonomy: Taxonomy with Entity,
  tags: Seq[Tag with Entity]
) {
  def _id: EntityId               = taxonomy._id
  def _createdBy: String          = taxonomy._createdBy
  def _updatedBy: Option[String]  = taxonomy._updatedBy
  def _createdAt: Date            = taxonomy._createdAt
  def _updatedAt: Option[Date]    = taxonomy._updatedAt
  def namespace: String           = taxonomy.namespace
  def description: String         = taxonomy.description
  def version: Int                = taxonomy.version
  def enabled: Boolean            = taxonomy.enabled
}
