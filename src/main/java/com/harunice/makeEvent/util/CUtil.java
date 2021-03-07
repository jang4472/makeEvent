package com.harunice.makeEvent.util;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CUtil {

	public static long getAsLong(Object object) {
		if ( object instanceof BigDecimal ) {
			return ((BigDecimal)object).longValue();
		}
		if ( object instanceof BigInteger ) {
			return ((BigInteger)object).longValue();
		}
		else if ( object instanceof Long ) {
			return (long)object;
		}
		else if ( object instanceof Integer ) {
			return (long)object;
		}
		else if ( object instanceof String ) {
			return Long.parseLong((String)object);
		}
		
		return -1;
	}

}
