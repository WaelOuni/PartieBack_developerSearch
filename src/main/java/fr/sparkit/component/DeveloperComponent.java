package fr.sparkit.component;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import fr.sparkit.developer.Developer;

@Component
public class DeveloperComponent {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	public Page<Developer> getdevelopers(String keyWord) {
		QueryBuilder query = QueryBuilders.boolQuery()
				.should(QueryBuilders.queryStringQuery(keyWord).field("name").field("lastName").field("town")
						.field("description").field("email"))
				.should(QueryBuilders.queryStringQuery("*" + keyWord + "*").field("name").field("lastName")
						.field("town").field("description").field("email"));
		NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();
		Page<Developer> developer = elasticsearchTemplate.queryForPage(build, Developer.class);

		return developer;

	}

}