import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import com.etrump.mixlayout.ETDecoration;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETSegment;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.EmoCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.SystemEmoCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import java.util.ArrayList;
import java.util.Iterator;

public class vfv
{
  private int jdField_a_of_type_Int;
  private Point jdField_a_of_type_AndroidGraphicsPoint;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect(1000, 1000, 0, 0);
  private ETFont jdField_a_of_type_ComEtrumpMixlayoutETFont;
  private String jdField_a_of_type_JavaLangString;
  ArrayList<vgr> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private Point[] jdField_a_of_type_ArrayOfAndroidGraphicsPoint;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  private int jdField_b_of_type_Int;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect(1000, 1000, 0, 0);
  private boolean jdField_b_of_type_Boolean;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  private static int a(char paramChar1, char paramChar2)
  {
    return (paramChar1 << '\n') + paramChar2 - 56613888;
  }
  
  private void a(Rect paramRect1, Rect paramRect2)
  {
    if (paramRect2.left < paramRect1.left) {
      paramRect1.left = paramRect2.left;
    }
    if (paramRect2.top < paramRect1.top) {
      paramRect1.top = paramRect2.top;
    }
    if (paramRect2.right > paramRect1.right) {
      paramRect1.right = paramRect2.right;
    }
    if (paramRect2.bottom > paramRect1.bottom) {
      paramRect1.bottom = paramRect2.bottom;
    }
  }
  
  private ETSegment[] a(ArrayList<vgr> paramArrayList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    this.g = paramArrayList.size();
    paramArrayList = paramArrayList.iterator();
    int m = 0;
    int j = 0;
    int n = 0;
    int i = 0;
    Object localObject1;
    Rect localRect1;
    int i2;
    int i1;
    int k;
    Object localObject2;
    Rect localRect2;
    int i3;
    ETSegment localETSegment;
    for (;;)
    {
      if (paramArrayList.hasNext())
      {
        localObject1 = (vgr)paramArrayList.next();
        int i4 = ((vgr)localObject1).c();
        if (i4 != 0)
        {
          localRect1 = new Rect(1000, 1000, 0, 0);
          i2 = 0;
          i1 = 0;
          k = i;
          if (i2 < i4)
          {
            localObject2 = ((vgr)localObject1).a(i2);
            localRect2 = ((vgr)localObject1).a(i2);
            i3 = 1;
            i = i3;
            if (!this.jdField_b_of_type_Boolean) {
              if (((TextCell)localObject2).type != 3)
              {
                i = i3;
                if (((TextCell)localObject2).type != 9) {}
              }
              else
              {
                i = i3;
                if (((TextCell)localObject2).useDefaultFont) {
                  i = 0;
                }
              }
            }
            i3 = localRect2.top - m;
            if (i != 0)
            {
              a(localRect1, localRect2);
              localETSegment = new ETSegment();
              localETSegment.type = 0;
              localETSegment.codePoint = -1;
              localETSegment.textOffset = 0;
              localETSegment.textLength = 0;
              localETSegment.lineNum = 0;
              localETSegment.textSize = 0;
              localETSegment.x = 0;
              localETSegment.y = 0;
              if ((localObject2 instanceof EmoCell))
              {
                localETSegment.type = 2;
                localETSegment.codePoint = k;
                localETSegment.y = (m + i3);
                i = (int)((EmoCell)localObject2).getWidth(null);
                localArrayList2.add(new fn(((EmoCell)localObject2).getEmoDrawable()));
                k += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label329:
      localETSegment.x = i1;
      i3 = (int)((TextCell)localObject2).fontSize;
      if ((((TextCell)localObject2).useSuperFont) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null)) {
        i3 = this.jdField_a_of_type_ComEtrumpMixlayoutETFont.getSize();
      }
      for (;;)
      {
        localETSegment.textSize = i3;
        localETSegment.lineNum = n;
        localArrayList3.add(localETSegment);
        for (;;)
        {
          i2 += 1;
          i1 += i;
          break;
          if ((localObject2 instanceof SystemEmoCell))
          {
            if (((TextCell)localObject2).getText().length() > 1) {}
            for (localETSegment.codePoint = a(((TextCell)localObject2).getText().charAt(0), ((TextCell)localObject2).getText().charAt(1));; localETSegment.codePoint = ((TextCell)localObject2).getText().charAt(0))
            {
              localETSegment.type = 1;
              localETSegment.y = (m + i3);
              i = (int)((SystemEmoCell)localObject2).getWidth(null);
              break;
            }
          }
          String str = ((TextCell)localObject2).getText();
          if (str == null) {
            break label768;
          }
          localETSegment.textLength = str.length();
          localETSegment.textOffset = j;
          localETSegment.type = 0;
          j += str.length();
          localETSegment.y = (m + i3 + 0);
          i = localRect2.width();
          break label329;
          if ((localObject2 instanceof EmoCell)) {
            i = (int)((EmoCell)localObject2).getWidth(null);
          } else if ((localObject2 instanceof SystemEmoCell)) {
            i = (int)((SystemEmoCell)localObject2).getWidth(null);
          } else {
            i = localRect2.width();
          }
        }
        localObject1 = new Point(0, 0);
        localObject2 = new Point(0, 0);
        ((Point)localObject1).x = localRect1.left;
        ((Point)localObject1).y = localRect1.top;
        localArrayList1.add(localObject1);
        ((Point)localObject2).x = localRect1.right;
        ((Point)localObject2).y = localRect1.bottom;
        localArrayList1.add(localObject2);
        i = localRect1.height();
        n += 1;
        m += i;
        i = k;
        break;
        this.jdField_a_of_type_ArrayOfJavaLangObject = localArrayList2.toArray();
        this.jdField_a_of_type_ArrayOfAndroidGraphicsPoint = ((Point[])localArrayList1.toArray(new Point[localArrayList1.size()]));
        return (ETSegment[])localArrayList3.toArray(new ETSegment[localArrayList3.size()]);
      }
      label768:
      i = 0;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Rect a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRect;
  }
  
  public ETDecoration a(ETEngine paramETEngine, boolean paramBoolean)
  {
    ETSegment[] arrayOfETSegment = a(this.jdField_a_of_type_JavaUtilArrayList);
    return ETDecoration.createDecorationSpace(paramETEngine, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPoint, this.e, this.jdField_a_of_type_ArrayOfAndroidGraphicsPoint, this.g, arrayOfETSegment, this.jdField_a_of_type_ArrayOfJavaLangObject, this.jdField_a_of_type_Boolean, this.f, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, paramBoolean);
  }
  
  public ETFont a()
  {
    return this.jdField_a_of_type_ComEtrumpMixlayoutETFont;
  }
  
  public String a(ArrayList<vgr> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramArrayList.size();
    int i = 0;
    while (i < k)
    {
      vgr localvgr = (vgr)paramArrayList.get(i);
      int m = localvgr.c();
      int j = 0;
      while (j < m)
      {
        localStringBuilder.append(localvgr.a(j).getText());
        j += 1;
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public void a(ETEngine paramETEngine, Bitmap paramBitmap, ETDecoration paramETDecoration, boolean paramBoolean)
  {
    int i = 0;
    if ((paramETEngine == null) || (paramBitmap == null)) {}
    while ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0) || (paramETDecoration == null)) {
      return;
    }
    if (paramBoolean)
    {
      paramETDecoration.drawSceneSpace(paramBitmap, 0, 0, this.jdField_a_of_type_ComEtrumpMixlayoutETFont);
      return;
    }
    paramETEngine = paramETDecoration.getMargins();
    int j;
    if (paramETEngine != null)
    {
      j = paramETEngine.left + 0;
      i = 0 + paramETEngine.top;
    }
    for (;;)
    {
      paramETDecoration.drawBackgroundSpace(paramBitmap, this.jdField_a_of_type_ComEtrumpMixlayoutETFont, j, i);
      return;
      j = 0;
    }
  }
  
  public boolean a(ArrayList<vgr> paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, ETFont paramETFont)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (a(this.jdField_a_of_type_JavaUtilArrayList).equals(a(paramArrayList))) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont != null) && (this.jdField_a_of_type_ComEtrumpMixlayoutETFont.equals(paramETFont)) && (paramInt4 == this.f) && (paramInt3 == this.e) && (paramBoolean1 == this.jdField_a_of_type_Boolean)) {
      return false;
    }
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_ComEtrumpMixlayoutETFont = paramETFont;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.f = paramInt4;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.e = paramInt3;
    paramETFont = new StringBuilder();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    vgr localvgr1;
    vgr localvgr2;
    TextCell localTextCell;
    Rect localRect;
    if (paramBoolean2)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localvgr1 = (vgr)paramArrayList.next();
        localvgr2 = new vgr();
        paramInt2 = localvgr1.c();
        if (paramInt2 != 0)
        {
          paramInt1 = 0;
          if (paramInt1 < paramInt2)
          {
            localTextCell = localvgr1.a(paramInt1);
            localRect = localvgr1.a(paramInt1);
            localvgr2.a(localTextCell, localRect);
            a(this.jdField_a_of_type_AndroidGraphicsRect, localRect);
            if ((localTextCell instanceof EmoCell)) {}
            for (;;)
            {
              paramInt1 += 1;
              break;
              if (!(localTextCell instanceof SystemEmoCell)) {
                paramETFont.append(localTextCell.getText());
              }
            }
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localvgr2);
        }
      }
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localvgr1 = (vgr)paramArrayList.next();
      localvgr2 = new vgr();
      paramInt2 = localvgr1.c();
      if (paramInt2 != 0)
      {
        paramInt1 = 0;
        if (paramInt1 < paramInt2)
        {
          localTextCell = localvgr1.a(paramInt1);
          localRect = localvgr1.a(paramInt1);
          if (((localTextCell.type == 3) || (localTextCell.type == 9)) && (localTextCell.useDefaultFont)) {
            a(this.jdField_b_of_type_AndroidGraphicsRect, localRect);
          }
          for (;;)
          {
            localvgr2.a(localTextCell, localRect);
            paramInt1 += 1;
            break;
            a(this.jdField_a_of_type_AndroidGraphicsRect, localRect);
            if ((!(localTextCell instanceof EmoCell)) && (!(localTextCell instanceof SystemEmoCell))) {
              paramETFont.append(localTextCell.getText());
            }
          }
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localvgr2);
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
    {
      this.c = this.jdField_b_of_type_AndroidGraphicsRect.right;
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidGraphicsRect.width();
      if (this.jdField_b_of_type_Int <= this.jdField_a_of_type_AndroidGraphicsRect.height()) {
        break label553;
      }
    }
    label553:
    for (paramInt1 = this.jdField_b_of_type_Int;; paramInt1 = this.jdField_a_of_type_AndroidGraphicsRect.height())
    {
      this.jdField_b_of_type_Int = paramInt1;
      this.e = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_JavaLangString = paramETFont.toString();
      this.jdField_a_of_type_AndroidGraphicsPoint = new Point(this.c, this.d);
      return true;
    }
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vfv
 * JD-Core Version:    0.7.0.1
 */