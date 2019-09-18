package rpc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import entity.Item;
import entity.Item.ItemBuilder;


public class RpcHelperTest {

	

	@Test
	public void testGetJSONArray() throws JSONException {
		Set<String> category = new HashSet<String>();
		category.add("category one");
		ItemBuilder ib = new ItemBuilder();
		ib.setItemId("one");
		ib.setRating(5);
		ib.setCategories(category);
        Item one = ib.build();
        ItemBuilder ib2 = new ItemBuilder();
        ib2.setItemId("two");
        ib2.setRating(5);
        ib2.setCategories(category);
		Item two = ib2.build();
		List<Item> listItem = new ArrayList<Item>();
		listItem.add(one);
		listItem.add(two);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(one.toJSONObject());
		jsonArray.put(two.toJSONObject());
		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);

		
		Item empty = new ItemBuilder().build();
		jsonArray.put(empty.toJSONObject());

		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
	}

	
	

}
