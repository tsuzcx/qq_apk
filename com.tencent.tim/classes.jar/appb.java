import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.SparseIntArray;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.widget.ColorClearableEditText.a;
import com.tencent.mobileqq.widget.ColorClearableEditText.b;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class appb
  extends DynamicDrawableSpan
{
  private ColorClearableEditText.b a = new ColorClearableEditText.b();
  private String cqm = "";
  private String cqn = "";
  private String cqo = "";
  private String cqp;
  private int displayWidth = -1;
  private Context mContext;
  private Drawable mDrawable;
  private int maxWidth;
  
  private appb(Context paramContext, String paramString1, String paramString2, int paramInt, Paint paramPaint)
  {
    super(0);
    this.cqm = paramString1;
    this.cqn = d(String.format("%s%s", new Object[] { "@", new aofe(paramString2, 32).k() }));
    this.maxWidth = paramInt;
    this.mContext = paramContext;
    c(paramPaint);
  }
  
  private appb(Context paramContext, String paramString1, String paramString2, int paramInt, Paint paramPaint, String paramString3)
  {
    this(paramContext, paramString1, paramString2, paramInt, paramPaint);
    this.cqp = d(String.format("%s%s", new Object[] { "@", new aofe(paramString3, 32).k() }));
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, EditText paramEditText)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramEditText == null)) {
      return null;
    }
    int i = paramEditText.getWidth();
    int j = paramEditText.getPaddingLeft();
    int k = paramEditText.getPaddingRight();
    try
    {
      paramQQAppInterface = new appb(paramContext, paramString2, paramString3, i - j - k, paramEditText.getPaint(), paramString4);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.cqn;
      paramString1 = new SpannableString(new aofe(paramContext + " ", 16).getText());
      paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    }
    return paramString1;
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2)
  {
    return a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, paramEditText, paramBoolean2, false);
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramEditText == null)) {
      return null;
    }
    appb[] arrayOfappb = (appb[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), appb.class);
    int i = paramEditText.getWidth();
    int j = paramEditText.getPaddingLeft();
    int k = paramEditText.getPaddingRight();
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, i - j - k, paramEditText.getPaint(), paramBoolean2);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.cqn;
      paramString1 = new SpannableString(new aofe(paramContext + " ", 16).getText());
      paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    }
    return paramString1;
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, 400, new Paint(), paramBoolean2);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.cqn;
      paramString1 = new SpannableString(paramContext + " ");
      paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    }
    return paramString1;
  }
  
  private static appb a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, int paramInt, Paint paramPaint, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInt <= 0)) {}
    for (;;)
    {
      return null;
      if (paramBoolean2) {
        if ((!paramBoolean1) && (!paramString2.equalsIgnoreCase("0")))
        {
          paramString1 = aqgv.o(paramQQAppInterface, paramString1, paramString2);
          paramQQAppInterface = paramString1;
          if (TextUtils.isEmpty(paramString1))
          {
            paramQQAppInterface = paramString1;
            if (!TextUtils.isEmpty(paramString3)) {
              paramQQAppInterface = paramString3;
            }
          }
        }
      }
      while (!TextUtils.isEmpty(paramQQAppInterface))
      {
        if (QLog.isColorLevel()) {
          QLog.d("_At_Me_DISC", 2, " memUin:" + paramString2 + " troopMemName:" + aqft.pk(paramQQAppInterface) + " isTroop:" + paramBoolean2);
        }
        return new appb(paramContext, paramString2, paramQQAppInterface, paramInt, paramPaint);
        paramQQAppInterface = paramString3;
        continue;
        if (!paramString2.equalsIgnoreCase("0"))
        {
          paramString1 = aqgv.c(paramQQAppInterface, paramString2, true);
          paramQQAppInterface = paramString1;
          if (w(paramString2, paramString1, paramString3)) {
            paramQQAppInterface = paramString3;
          }
        }
        else
        {
          paramQQAppInterface = paramString3;
        }
      }
    }
  }
  
  public static String a(Spannable paramSpannable, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramSpannable == null)) {
      return "";
    }
    paramArrayList.clear();
    StringBuffer localStringBuffer = new StringBuffer(paramSpannable.toString());
    int m = localStringBuffer.length();
    appb[] arrayOfappb = (appb[])paramSpannable.getSpans(0, m - 1, appb.class);
    if (arrayOfappb.length == 0) {
      return localStringBuffer.toString();
    }
    if (arrayOfappb.length > 1) {
      Arrays.sort(arrayOfappb, new appc(paramSpannable));
    }
    int j = 0;
    int i = 0;
    int n;
    int i1;
    for (;;)
    {
      if (i >= arrayOfappb.length) {
        break label345;
      }
      appb localappb = arrayOfappb[i];
      n = paramSpannable.getSpanStart(localappb) + j;
      i1 = paramSpannable.getSpanEnd(localappb) + j;
      String str = localappb.cqn;
      if (!TextUtils.isEmpty(localappb.cqp)) {
        str = localappb.cqp;
      }
      try
      {
        localStringBuffer.replace(n, i1, str);
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
        localAtTroopMemberInfo.uin = Long.valueOf(localappb.cqm).longValue();
        if ((localappb.cqm != null) && (localappb.cqm.equalsIgnoreCase("0"))) {
          localAtTroopMemberInfo.flag = 1;
        }
        localAtTroopMemberInfo.startPos = ((short)n);
        localAtTroopMemberInfo.textLen = ((short)str.length());
        paramArrayList.add(localAtTroopMemberInfo);
        k = j + (localAtTroopMemberInfo.textLen - (i1 - n));
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        for (;;)
        {
          int k = j;
          if (QLog.isColorLevel())
          {
            QLog.e("AtTroopMemberSpan", 2, String.format(localStringBuffer.toString() + ",IndexOutOfBoundsException, convertToSendMsg, start:%d | end:%d | msgBLen:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(m) }));
            k = j;
          }
        }
      }
      i += 1;
      j = k;
    }
    label345:
    return localStringBuffer.toString();
  }
  
  public static StringBuilder a(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramStringBuilder.toString())) || (TextUtils.isEmpty(paramString2)) || (paramBoolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AtTroopMemberSpan_At_Me_DISC", 2, "Recv replaceAtMsgByMarkName return discUin:" + paramString2);
      }
      paramString1 = paramStringBuilder;
    }
    do
    {
      return paramString1;
      try
      {
        localJSONArray = new JSONArray(paramString1);
        m = localJSONArray.length();
        i = 0;
        j = 0;
      }
      catch (JSONException paramQQAppInterface)
      {
        try
        {
          JSONArray localJSONArray;
          int m;
          int i;
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          int i1 = (byte)localJSONObject.optInt("flag", 1);
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          String str = localJSONObject.optString("uin");
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          int i2 = localJSONObject.optInt("startPos", 0);
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          int n = localJSONObject.optInt("textLen", 0);
          int k = j;
          paramString1 = paramStringBuilder;
          if (i1 == 0)
          {
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            str = "@" + aqgv.m(paramQQAppInterface, paramString2, str);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            paramStringBuilder = paramStringBuilder.replace(i2 + j, i2 + n + j, str);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            k = str.length();
            k = j + (k - n);
            paramString1 = paramStringBuilder;
          }
          i += 1;
          int j = k;
          paramStringBuilder = paramString1;
        }
        catch (Exception paramQQAppInterface)
        {
          StringBuilder localStringBuilder;
          break label296;
        }
        catch (JSONException paramQQAppInterface)
        {
          break label280;
        }
        paramQQAppInterface = paramQQAppInterface;
        localStringBuilder = paramStringBuilder;
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_1 ", paramQQAppInterface);
        return localStringBuilder;
      }
      catch (Exception paramQQAppInterface)
      {
        paramString1 = paramStringBuilder;
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_2", paramQQAppInterface);
        return paramString1;
      }
      paramString1 = paramStringBuilder;
    } while (i >= m);
    paramString1 = paramStringBuilder;
    localStringBuilder = paramStringBuilder;
  }
  
  private List<ColorClearableEditText.a> a(Paint paramPaint)
  {
    int i = (int)Math.ceil(paramPaint.measureText(" "));
    List localList = aqpm.a(this.maxWidth - i * 2, this.cqn, paramPaint, this.a, 16);
    localList.add(new ColorClearableEditText.a(1, 0, 0, "  ", null));
    this.displayWidth = aqpm.a(localList, paramPaint, new Rect());
    return localList;
  }
  
  public static void a(int paramInt, String paramString, ChatMessage paramChatMessage)
  {
    if (paramInt == 1) {
      paramChatMessage.saveExtInfoToExtStr("troop_at_info_list", paramString);
    }
    while (paramInt != 3000) {
      return;
    }
    paramChatMessage.saveExtInfoToExtStr("disc_at_info_list", paramString);
  }
  
  public static void a(int paramInt, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, ChatMessage paramChatMessage)
  {
    if (((paramInt == 3000) || (paramInt == 1)) && (paramArrayList.size() > 0))
    {
      try
      {
        JSONArray localJSONArray = new JSONArray();
        paramArrayList = paramArrayList.iterator();
        int i = 0;
        while (paramArrayList.hasNext())
        {
          localJSONArray.put(i, ((MessageForText.AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
          i += 1;
        }
        if (paramInt == 1)
        {
          paramChatMessage.saveExtInfoToExtStr("troop_at_info_list", localJSONArray.toString());
          return;
        }
        if (paramInt != 3000) {
          return;
        }
        paramChatMessage.saveExtInfoToExtStr("disc_at_info_list", localJSONArray.toString());
        return;
      }
      catch (JSONException paramArrayList)
      {
        paramArrayList.printStackTrace();
        return;
      }
    }
    else if (((paramInt == 3000) || (paramInt == 1)) && (paramArrayList.size() == 0))
    {
      if (paramInt == 1)
      {
        paramChatMessage.removeExtInfoToExtStr("troop_at_info_list");
        return;
      }
      if (paramInt == 3000) {
        paramChatMessage.removeExtInfoToExtStr("disc_at_info_list");
      }
    }
  }
  
  private void c(Paint paramPaint)
  {
    float f1 = 0.0F;
    if (this.mDrawable != null) {
      return;
    }
    Object localObject2 = a(paramPaint);
    Object localObject1 = paramPaint.getFontMetrics();
    float f2 = -((Paint.FontMetrics)localObject1).top;
    int i = (int)Math.ceil(((Paint.FontMetrics)localObject1).bottom - ((Paint.FontMetrics)localObject1).top);
    Object localObject3 = new RectF(0.0F, ((Paint.FontMetrics)localObject1).ascent - ((Paint.FontMetrics)localObject1).top, this.displayWidth - 2, ((Paint.FontMetrics)localObject1).descent + f2);
    localObject1 = Bitmap.createBitmap(this.displayWidth, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject1);
    int j = paramPaint.getColor();
    paramPaint.setColor(-4331268);
    localCanvas.drawRect((RectF)localObject3, paramPaint);
    paramPaint.setColor(j);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ColorClearableEditText.a)((Iterator)localObject2).next();
      switch (((ColorClearableEditText.a)localObject3).type)
      {
      default: 
        break;
      case 1: 
        localCanvas.drawText(((ColorClearableEditText.a)localObject3).text, f1, f2, paramPaint);
        f1 += paramPaint.measureText(((ColorClearableEditText.a)localObject3).text);
        break;
      case 2: 
        localObject3 = (aofk.a)((ColorClearableEditText.a)localObject3).a;
        j = ((aofk.a)localObject3).getDrawable().getBounds().height();
        ((aofk.a)localObject3).draw(localCanvas, "", 0, 0, f1, (i - j) / 2, (i + j) / 2, (j + i) / 2, paramPaint);
        f1 += ((aofk.a)localObject3).getDrawable().getBounds().width();
      }
    }
    localCanvas.save();
    localCanvas.restore();
    this.mDrawable = new BitmapDrawable(this.mContext.getResources(), (Bitmap)localObject1);
    i = this.mDrawable.getIntrinsicHeight();
    paramPaint = this.mDrawable;
    j = this.displayWidth;
    if (i > 0) {}
    for (;;)
    {
      paramPaint.setBounds(0, 0, j, i);
      return;
      i = 0;
    }
  }
  
  private static String d(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int k = paramCharSequence.codePointAt(i);
      int j;
      if ((k == 20) && (i < paramCharSequence.length() - 1))
      {
        paramCharSequence.delete(i, i + 2);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (aoff.ah.get(k, -1) < 0);
      if ((k > 65535) && (paramCharSequence.length() >= i + 2)) {
        paramCharSequence.delete(i, i + 2);
      }
      for (;;)
      {
        j = i - 1;
        break;
        paramCharSequence.delete(i, i + 1);
      }
    }
    return paramCharSequence.toString();
  }
  
  public static String v(ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList)
  {
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      while (paramArrayList.hasNext())
      {
        localJSONArray.put(i, ((MessageForText.AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
        i += 1;
      }
      paramArrayList = localJSONArray.toString();
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      QLog.e("AtTroopMemberSpan", 1, "convertAtinfo2Json fail: ", paramArrayList);
    }
    return null;
  }
  
  private static boolean w(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!TextUtils.isEmpty(paramString2))
    {
      bool1 = bool2;
      if (!paramString2.equals(paramString1)) {}
    }
    else
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString3)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String Bw()
  {
    return this.cqm;
  }
  
  public String Bx()
  {
    return this.cqn;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    if ((paramInt2 - paramInt1 == 1) && (this.cqo.length() != 1) && (paramInt1 != 0)) {
      return;
    }
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    if ((this.mDrawable == null) || ((paramInt2 - paramInt1 == 1) && (this.cqo.length() != 1) && (paramInt1 != 0))) {
      return 0;
    }
    return this.mDrawable.getBounds().right;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     appb
 * JD-Core Version:    0.7.0.1
 */