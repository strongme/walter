package org.strongme.walter;

import java.util.Comparator;

import org.springframework.stereotype.Service;

@Service
public class CaseInsensitiveComparator implements Comparator<String> {

	public int compare(String o1, String o2) {
		assert o1 !=null&&o2!=null;
		return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
	}

}
