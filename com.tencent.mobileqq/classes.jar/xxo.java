import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.LengthConvertor;

public final class xxo
  implements ExtendEditText.LengthConvertor
{
  public int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 - paramInt1;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return -paramInt1;
  }
  
  public int b(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    paramInt1 = paramInt2 - paramInt1;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return -paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xxo
 * JD-Core Version:    0.7.0.1
 */