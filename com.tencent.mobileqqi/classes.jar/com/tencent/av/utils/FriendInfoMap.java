package com.tencent.av.utils;

import android.graphics.Bitmap;
import blz;
import java.util.HashMap;

public class FriendInfoMap
{
  HashMap a = new HashMap();
  
  public Bitmap a(long paramLong)
  {
    if (this.a.containsKey(Long.valueOf(paramLong))) {
      return ((blz)this.a.get(Long.valueOf(paramLong))).jdField_a_of_type_AndroidGraphicsBitmap;
    }
    return null;
  }
  
  public String a(long paramLong)
  {
    if (this.a.containsKey(Long.valueOf(paramLong))) {
      return ((blz)this.a.get(Long.valueOf(paramLong))).jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public void a(long paramLong, String paramString, Bitmap paramBitmap)
  {
    blz localblz = new blz(this);
    localblz.jdField_a_of_type_JavaLangString = paramString;
    localblz.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.a.put(Long.valueOf(paramLong), localblz);
  }
  
  public boolean a(long paramLong)
  {
    return this.a.containsKey(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.utils.FriendInfoMap
 * JD-Core Version:    0.7.0.1
 */