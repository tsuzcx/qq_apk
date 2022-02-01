package com.squareup.okhttp.internal.http;

import java.util.Comparator;

final class OkHeaders$1
  implements Comparator<String>
{
  public int compare(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return 0;
    }
    if (paramString1 == null) {
      return -1;
    }
    if (paramString2 == null) {
      return 1;
    }
    return String.CASE_INSENSITIVE_ORDER.compare(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.internal.http.OkHeaders.1
 * JD-Core Version:    0.7.0.1
 */