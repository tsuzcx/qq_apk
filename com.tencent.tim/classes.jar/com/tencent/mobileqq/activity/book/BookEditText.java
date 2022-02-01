package com.tencent.mobileqq.activity.book;

import android.content.Context;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import java.io.UnsupportedEncodingException;
import ymf;

public class BookEditText
  extends EditText
{
  private a jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText$a;
  private InputFilter[] jdField_a_of_type_ArrayOfAndroidTextInputFilter = { new ymf(this) };
  private int bZR = 80;
  private boolean bny;
  
  public BookEditText(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BookEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setInputType(131072);
    setSingleLine(false);
    setHorizontallyScrolling(false);
    setFilters(this.jdField_a_of_type_ArrayOfAndroidTextInputFilter);
  }
  
  public int bQ(String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    try
    {
      int i = paramString.toString().getBytes("utf8").length;
      return i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return paramString.toString().getBytes().length;
  }
  
  public void setCanInputWhenLenghtLimit(boolean paramBoolean)
  {
    this.bny = paramBoolean;
  }
  
  public void setInputListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText$a = parama;
  }
  
  public void setTextLengthLimit(int paramInt)
  {
    this.bZR = paramInt;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.book.BookEditText
 * JD-Core Version:    0.7.0.1
 */