package dov.com.qq.im.capture.text;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import axug;
import axui;
import ayjw.c;
import ayoo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import org.json.JSONArray;

public abstract class DynamicTextItem
{
  private static final String TAG = DynamicTextItem.class.getSimpleName();
  private TextMap jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap;
  private volatile a<Integer, Boolean> jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$a = new a(Integer.valueOf(-1), Boolean.valueOf(false));
  private volatile boolean aHB;
  protected StaticLayout b;
  private Paint db;
  protected boolean dwE;
  private boolean dwF;
  private volatile boolean dwG;
  private int eHv = 0;
  private Handler el;
  public boolean mIsCanceled;
  private int mType;
  public Stack<Integer> o = new Stack();
  protected int textSize;
  
  public DynamicTextItem(int paramInt, @NonNull List<String> paramList)
  {
    this.mType = paramInt;
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap = new TextMap(paramList);
    this.db = new Paint();
    this.db.setAntiAlias(true);
    this.db.setColor(Color.parseColor("#12b7f5"));
    this.db.setStyle(Paint.Style.STROKE);
    this.db.setStrokeWidth(2.0F);
    this.db.setPathEffect(new DashPathEffect(new float[] { 6.0F, 7.0F }, 1.0F));
  }
  
  private int lP(int paramInt)
  {
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < Rv()) {}
    }
    else
    {
      i = 0;
    }
    return i;
  }
  
  public String Ii()
  {
    return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.getText(Rw());
  }
  
  public String R(int paramInt, String paramString)
  {
    if (paramString.length() <= paramInt) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = 0;
    int i = 0;
    if (k < paramString.length())
    {
      if (paramString.charAt(k) == ' ') {}
      for (int j = i + 1;; j = 0)
      {
        localStringBuilder.append(paramString.charAt(k));
        i = j;
        if (j == paramInt)
        {
          i = j;
          if (k + 1 <= paramString.length() - 1)
          {
            i = j;
            if (paramString.charAt(k + 1) == ' ')
            {
              localStringBuilder.append("\r\n");
              i = 0;
            }
          }
        }
        k += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public abstract int Rv();
  
  public int Rw()
  {
    if (this.eHv < 0) {
      this.eHv = 0;
    }
    if (this.eHv >= this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.size()) {
      return 0;
    }
    return this.eHv;
  }
  
  public void YZ(boolean paramBoolean)
  {
    this.dwF = paramBoolean;
  }
  
  public float a(StaticLayout paramStaticLayout)
  {
    float f1 = 0.0F;
    float f2 = 0.0F;
    if (paramStaticLayout == null) {
      return f2;
    }
    int i = 0;
    for (;;)
    {
      f2 = f1;
      if (i >= paramStaticLayout.getLineCount()) {
        break;
      }
      f1 = Math.max(f1, paramStaticLayout.getLineWidth(i));
      i += 1;
    }
  }
  
  public int a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return -1;
  }
  
  public int a(@NonNull MotionEvent paramMotionEvent, float paramFloat1, float paramFloat2, @Nullable ayjw.c paramc, ayoo paramayoo)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(TAG, 2, "=========================================");
      QLog.d(TAG, 2, "Touch X: " + paramMotionEvent.getX());
      QLog.d(TAG, 2, "Touch Y: " + paramMotionEvent.getY());
      QLog.d(TAG, 2, "Container W: " + paramFloat1);
      QLog.d(TAG, 2, "Container H: " + paramFloat2);
      if (paramc != null) {
        break label208;
      }
      QLog.d(TAG, 2, "Text Zoom info is null, use default info");
      QLog.d(TAG, 2, "Text W: " + getWidth());
      QLog.d(TAG, 2, "Text H: " + getHeight());
    }
    for (;;)
    {
      QLog.d(TAG, 2, "=========================================");
      return -1;
      label208:
      QLog.d(TAG, 2, "Text X: " + paramc.centerP.x);
      QLog.d(TAG, 2, "Text Y: " + paramc.centerP.y);
      QLog.d(TAG, 2, "Text W: " + paramc.c.getWidth());
      QLog.d(TAG, 2, "Text H: " + paramc.c.getHeight());
      QLog.d(TAG, 2, "Text Scale: " + paramayoo.a(paramc));
      QLog.d(TAG, 2, "Text Matrix: " + paramayoo.a(paramc));
      QLog.d(TAG, 2, "Text translateX: " + paramc.translateXValue);
      QLog.d(TAG, 2, "Text translateY: " + paramc.translateYValue);
      QLog.d(TAG, 2, "Text rotate: " + paramc.nI);
    }
  }
  
  public InputFilter a()
  {
    return null;
  }
  
  @NonNull
  public TextMap a()
  {
    return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap;
  }
  
  @NonNull
  protected final String a(int paramInt, @Nullable b paramb)
  {
    paramInt = lP(paramInt);
    String str2 = getText(paramInt);
    String str1 = str2;
    if (paramb != null) {
      str1 = paramb.Q(paramInt, str2);
    }
    return sL(str1);
  }
  
  public void a(int paramInt1, View paramView, boolean paramBoolean, int paramInt2, int paramInt3, Runnable paramRunnable)
  {
    if ((this.aHB) || (!aPK())) {
      return;
    }
    this.aHB = true;
    this.dwG = true;
    if (this.el == null) {
      this.el = new Handler(Looper.getMainLooper());
    }
    for (;;)
    {
      int i = 0;
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$a.first = Integer.valueOf(paramInt1);
      paramInt1 = i;
      while (paramInt1 < paramInt2 - paramInt3)
      {
        this.el.postDelayed(new DynamicTextItem.1(this, paramView), paramInt1);
        paramInt1 += paramInt3;
      }
      this.el.removeCallbacksAndMessages(null);
    }
    this.el.postDelayed(new DynamicTextItem.2(this, paramBoolean, paramView, paramRunnable), paramInt1);
  }
  
  public abstract boolean aPK();
  
  public final boolean aPO()
  {
    return Rv() > 1;
  }
  
  public boolean aPP()
  {
    ArrayList localArrayList = eN();
    List localList = axug.at(this.mType);
    if (localList == null) {}
    int i;
    String str;
    do
    {
      do
      {
        return false;
      } while (localArrayList.size() < localList.size());
      i = 0;
      if (i >= localList.size()) {
        break label97;
      }
      str = (String)localList.get(i);
      if (str != null) {
        break;
      }
    } while (localArrayList.get(i) != null);
    while (str.equals(localArrayList.get(i)))
    {
      i += 1;
      break;
    }
    return false;
    label97:
    return true;
  }
  
  public boolean aPQ()
  {
    return this.dwF;
  }
  
  public boolean aPR()
  {
    return this.dwG;
  }
  
  public void aeK(int paramInt)
  {
    if (aPO())
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      this.eHv = i;
      return;
    }
    this.eHv = 0;
  }
  
  public void cz(int paramInt, boolean paramBoolean)
  {
    eOT();
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$a.first = Integer.valueOf(paramInt);
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$a.second = Boolean.valueOf(paramBoolean);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(-getWidth() / 2.0F, -getHeight() / 2.0F);
    onDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  @NonNull
  public ArrayList<String> eN()
  {
    return new ArrayList(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.hV());
  }
  
  public void eOT()
  {
    if (this.el != null) {
      this.el.removeCallbacksAndMessages(null);
    }
    this.aHB = false;
  }
  
  public void eOU()
  {
    eOT();
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$a.second = Boolean.valueOf(false);
  }
  
  public void eOV()
  {
    this.dwG = false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DynamicTextItem)paramObject;
      if (this.mType != paramObject.mType) {
        return false;
      }
      if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap != null) {
        return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.equals(paramObject.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap);
      }
    } while (paramObject.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap == null);
    return false;
  }
  
  @NonNull
  protected final String gW(int paramInt)
  {
    return a(paramInt, null);
  }
  
  public abstract float getHeight();
  
  @NonNull
  public String getText(int paramInt)
  {
    int i = paramInt;
    if (paramInt != lP(paramInt))
    {
      String str = "getText index out of bound, support size is " + Rv() + ", current index is " + paramInt;
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException(str);
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, localIndexOutOfBoundsException, new Object[] { str });
      }
      i = 0;
    }
    return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.getText(i);
  }
  
  public int getTextSize()
  {
    return this.textSize;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public abstract float getWidth();
  
  public int hashCode()
  {
    int j = this.mType;
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap != null) {}
    for (int i = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.hashCode();; i = 0) {
      return i + j * 31;
    }
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.bE(0, Rv());
  }
  
  @NonNull
  public Paint k()
  {
    return this.db;
  }
  
  protected abstract void onDraw(Canvas paramCanvas);
  
  public boolean ot(int paramInt)
  {
    return getText(paramInt).equals(axug.aa(this.mType, paramInt));
  }
  
  public boolean ou(int paramInt)
  {
    if ((((Integer)this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$a.first).intValue() == paramInt) || (((Integer)this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$a.first).intValue() == -1)) {
      return ((Boolean)this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$a.second).booleanValue();
    }
    return false;
  }
  
  public String sL(String paramString)
  {
    Object localObject = paramString;
    int j;
    if (this.mType != 0)
    {
      localObject = paramString;
      if (paramString.length() > 20)
      {
        localObject = new StringBuilder();
        i = 0;
        j = 0;
        if ((i < paramString.length()) && (j < 20)) {
          break label99;
        }
        paramString = ((StringBuilder)localObject).toString();
        localObject = paramString;
        if (!paramString.isEmpty()) {
          if (!Character.isHighSurrogate(paramString.charAt(paramString.length() - 1))) {
            break label151;
          }
        }
      }
    }
    label151:
    for (int i = paramString.length() - 1;; i = paramString.length())
    {
      localObject = paramString.substring(0, i);
      return localObject;
      label99:
      ((StringBuilder)localObject).append(paramString.charAt(i));
      int k = j;
      if (paramString.charAt(i) != '\n')
      {
        k = j;
        if (paramString.charAt(i) != '\r') {
          k = j + 1;
        }
      }
      i += 1;
      j = k;
      break;
    }
  }
  
  public void setText(int paramInt, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = paramInt;
    if (paramInt != lP(paramInt))
    {
      paramString = "setText index out of bound, support size is " + Rv() + ", current index is " + paramInt;
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException(paramString);
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, localIndexOutOfBoundsException, new Object[] { paramString });
      }
      i = 0;
    }
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem$TextMap.setText(i, str);
  }
  
  public void setTextSize(int paramInt)
  {
    this.dwE = true;
    this.textSize = paramInt;
  }
  
  public static class TextMap
    implements Parcelable
  {
    public static final Parcelable.Creator<TextMap> CREATOR = new axui();
    private Map<Integer, String> qP = new HashMap();
    
    public TextMap() {}
    
    public TextMap(Parcel paramParcel)
    {
      this();
      int j = paramParcel.readInt();
      int i = 0;
      while (i < j)
      {
        this.qP.put(Integer.valueOf(paramParcel.readInt()), paramParcel.readString());
        i += 1;
      }
    }
    
    public TextMap(@NonNull List<String> paramList)
    {
      this();
      if (paramList != null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          this.qP.put(Integer.valueOf(i), paramList.get(i));
          i += 1;
        }
      }
    }
    
    public boolean bE(int paramInt1, int paramInt2)
    {
      Iterator localIterator = this.qP.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if ((((Integer)localEntry.getKey()).intValue() >= paramInt1) && (((Integer)localEntry.getKey()).intValue() < paramInt2) && (!TextUtils.isEmpty((CharSequence)localEntry.getValue()))) {
          return false;
        }
      }
      return true;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      for (;;)
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (TextMap)paramObject;
        if (!this.qP.equals(paramObject.qP))
        {
          int j = this.qP.size();
          if (j != paramObject.qP.size()) {
            return false;
          }
          int i = 0;
          while (i < j)
          {
            if (!getText(i).equals(paramObject.getText(i))) {
              return false;
            }
            i += 1;
          }
        }
      }
    }
    
    @NonNull
    public String getText(int paramInt)
    {
      int i = size();
      if ((paramInt < 0) || (paramInt >= i)) {
        throw new IndexOutOfBoundsException("location " + paramInt + " is out of bounds, TextMap size is " + i);
      }
      String str2 = (String)this.qP.get(Integer.valueOf(paramInt));
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      return str1;
    }
    
    @NonNull
    public List<String> hV()
    {
      ArrayList localArrayList = new ArrayList();
      int j = size();
      int i = 0;
      while (i < j)
      {
        localArrayList.add(this.qP.get(Integer.valueOf(i)));
        i += 1;
      }
      return localArrayList;
    }
    
    public int hashCode()
    {
      return this.qP.hashCode();
    }
    
    public JSONArray l()
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(size());
        Iterator localIterator = this.qP.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localJSONArray.put(localEntry.getKey());
          localJSONArray.put(localEntry.getValue());
        }
        return localException;
      }
      catch (Exception localException)
      {
        return null;
      }
    }
    
    public void setText(int paramInt, @NonNull String paramString)
    {
      if (paramInt != -1) {
        this.qP.put(Integer.valueOf(paramInt), paramString);
      }
    }
    
    public int size()
    {
      Iterator localIterator = this.qP.entrySet().iterator();
      int i = -1;
      if (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Integer)localEntry.getKey()).intValue() <= i) {
          break label72;
        }
        i = ((Integer)localEntry.getKey()).intValue();
      }
      label72:
      for (;;)
      {
        break;
        return i + 1;
      }
    }
    
    public String toString()
    {
      int j = size();
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append((String)this.qP.get(Integer.valueOf(i))).append("#");
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.qP.size());
      Iterator localIterator = this.qP.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramParcel.writeInt(((Integer)localEntry.getKey()).intValue());
        paramParcel.writeString((String)localEntry.getValue());
      }
    }
  }
  
  public static class a<F, S>
  {
    public F first;
    public S second;
    
    public a(F paramF, S paramS)
    {
      this.first = paramF;
      this.second = paramS;
    }
  }
  
  public static abstract interface b
  {
    @NonNull
    public abstract String Q(int paramInt, @NonNull String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextItem
 * JD-Core Version:    0.7.0.1
 */