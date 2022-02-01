import android.graphics.Rect;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import java.util.ArrayList;

public class viv
{
  private int jdField_a_of_type_Int;
  private ArrayList<TextCell> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int;
  private ArrayList<Rect> jdField_b_of_type_JavaUtilArrayList;
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    }
    if (this.jdField_b_of_type_JavaUtilArrayList == null) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(1);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Rect a(int paramInt)
  {
    if (paramInt < 0) {}
    while (this.jdField_b_of_type_JavaUtilArrayList == null) {
      return null;
    }
    return (Rect)this.jdField_b_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public TextCell a(int paramInt)
  {
    if (paramInt < 0) {}
    while (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return null;
    }
    return (TextCell)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (;;)
    {
      return;
      int j = this.jdField_a_of_type_JavaUtilArrayList.size();
      if (paramInt < j)
      {
        int i = 0;
        while (i < j - paramInt)
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(j - i - 1);
          Rect localRect = (Rect)this.jdField_b_of_type_JavaUtilArrayList.remove(j - i - 1);
          if (localRect != null) {
            this.jdField_a_of_type_Int -= localRect.width();
          }
          i += 1;
        }
      }
    }
  }
  
  public void a(TextCell paramTextCell, Rect paramRect)
  {
    a();
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTextCell);
    this.jdField_b_of_type_JavaUtilArrayList.add(paramRect);
    if (paramRect != null) {
      this.jdField_a_of_type_Int += paramRect.width();
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int c()
  {
    int i;
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_b_of_type_JavaUtilArrayList == null)) {
      i = 0;
    }
    int j;
    int k;
    do
    {
      return i;
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      k = this.jdField_b_of_type_JavaUtilArrayList.size();
      i = j;
    } while (j < k);
    return k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     viv
 * JD-Core Version:    0.7.0.1
 */