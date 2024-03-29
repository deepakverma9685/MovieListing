package com.deepak.movielisting.ui.models

import androidx.room.Entity
import com.deepak.movielisting.utils.AppConstants
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class SearchModel(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<SearchResultsItem?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)

@Entity(primaryKeys = ["id"])
data class SearchResultsItem(

	var page: Int,
	var totalPages: Int,
	var favourites: Boolean = false,

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("original_language")
	val originalLanguage: String? = null,

	@field:SerializedName("original_title")
	val originalTitle: String? = null,

	@field:SerializedName("video")
	val video: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("poster_path")
	var posterPath: String? = null,

	@field:SerializedName("backdrop_path")
	val backdropPath: String? = null,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("popularity")
	val popularity: Double? = null,

	@field:SerializedName("vote_average")
	val voteAverage: Double? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("adult")
	val adult: Boolean? = null,

	@field:SerializedName("vote_count")
	val voteCount: Int? = null
): Serializable{
	fun getFormattedPosterPath(): String? {
		if (posterPath != null && !posterPath!!.startsWith("http")) {
			posterPath = String.format(AppConstants.IMAGE_URL, posterPath)
		}
		return posterPath
	}

	fun isLastPage() : Boolean {
		return page >= totalPages
	}

}


