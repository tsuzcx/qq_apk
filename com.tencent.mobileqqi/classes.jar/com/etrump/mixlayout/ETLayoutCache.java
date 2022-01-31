package com.etrump.mixlayout;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ETLayoutCache
{
  private static ETLayoutCache jdField_a_of_type_ComEtrumpMixlayoutETLayoutCache;
  public static final String a = "ETLayoutCache";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(2);
  
  public static ETLayoutCache a()
  {
    if (jdField_a_of_type_ComEtrumpMixlayoutETLayoutCache == null) {
      jdField_a_of_type_ComEtrumpMixlayoutETLayoutCache = new ETLayoutCache();
    }
    return jdField_a_of_type_ComEtrumpMixlayoutETLayoutCache;
  }
  
  public ETLayout a(int paramInt1, long paramLong, CharSequence paramCharSequence, ETFont paramETFont, int paramInt2)
  {
    Object localObject = null;
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    if (i < j)
    {
      ETLayout localETLayout = (ETLayout)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localETLayout.a(paramLong, paramETFont))
      {
        paramCharSequence = localETLayout;
        if (QLog.isColorLevel())
        {
          QLog.d("ETLayoutCache", 2, "same content size=" + this.jdField_a_of_type_JavaUtilArrayList.size() + ",fontId=" + paramETFont.a + ", id=" + paramLong);
          paramCharSequence = localETLayout;
        }
        label114:
        return paramCharSequence;
      }
      if (localETLayout.a() != 0) {
        break label340;
      }
      localObject = localETLayout;
    }
    label340:
    for (;;)
    {
      i += 1;
      break;
      if (localObject != null)
      {
        ((ETLayout)localObject).a(paramInt1, paramCharSequence, paramETFont, paramInt2);
        if (QLog.isColorLevel()) {
          QLog.d("ETLayoutCache", 2, "reuse layout size=" + this.jdField_a_of_type_JavaUtilArrayList.size() + ", fontId=" + paramETFont.a + ", id=" + paramLong);
        }
        ((ETLayout)localObject).a = paramLong;
        return localObject;
      }
      localObject = new ETLayout();
      ((ETLayout)localObject).a(paramInt1, paramCharSequence, paramETFont, paramInt2);
      ((ETLayout)localObject).a = paramLong;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 9) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      paramCharSequence = (CharSequence)localObject;
      if (!QLog.isColorLevel()) {
        break label114;
      }
      QLog.d("ETLayoutCache", 2, "new layout size=" + this.jdField_a_of_type_JavaUtilArrayList.size() + " fontId=" + paramETFont.a + ", mMsgId=" + paramLong);
      return localObject;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETLayoutCache
 * JD-Core Version:    0.7.0.1
 */