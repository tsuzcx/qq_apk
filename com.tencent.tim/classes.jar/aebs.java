import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class aebs
{
  private static final List<String> yD = new LinkedList();
  private static final List<String> yE = new ArrayList();
  private static final List<String> yF = new ArrayList();
  
  static
  {
    yD.add("buluo.qq.com");
    yD.add("null");
    yD.add("unregistered service sub type");
    yD.add("captcha.qq.com");
    yD.add("oauth.youzan.com");
    if (BaseApplicationImpl.getApplication() != null)
    {
      yD.add("https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process");
      yF.add("https://zb.vip.qq.com/sonic/funcall?_wv=16778243&asyncMode=3&_sonic_id=42898&_preload=1&from=call_process");
    }
  }
  
  public static String F(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    Object localObject = new ArrayList(paramList);
    paramList = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.append(a((ColorNote)((Iterator)localObject).next()));
    }
    return paramList.toString();
  }
  
  public static String G(List<ColorNote> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localStringBuilder.append(((ColorNote)paramList.next()).toString());
    }
    return localStringBuilder.toString();
  }
  
  public static ColorNote a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return null;
    }
    String str = BaseApplicationImpl.getContext().getString(2131691740);
    int i = paramColorNote.getServiceType();
    return new ColorNote.a().a(i | 0x80000000).a(paramColorNote.getSubType()).b(0).b(paramColorNote.getMainTitle()).c(str).d(paramColorNote.getPicUrl()).a(paramColorNote.getReserve()).a();
  }
  
  public static String a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return "";
    }
    return paramColorNote.getMainTitle() + ", " + paramColorNote.getSubTitle() + ". ";
  }
  
  public static boolean a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    if ((paramColorNote1 == null) || (paramColorNote2 == null)) {
      if ((paramColorNote1 != null) || (paramColorNote2 != null)) {}
    }
    while ((paramColorNote1.mServiceType == paramColorNote2.getServiceType()) && (aQ(paramColorNote1.mSubType, paramColorNote2.getSubType())) && (aQ(paramColorNote1.mMainTitle, paramColorNote2.getMainTitle())) && (aQ(paramColorNote1.mSubTitle, paramColorNote2.getSubTitle())))
    {
      return true;
      return false;
    }
    return false;
  }
  
  public static boolean aQ(String paramString1, String paramString2)
  {
    int i;
    if (!aqmr.isEmpty(paramString1))
    {
      i = 1;
      if (aqmr.isEmpty(paramString2)) {
        break label31;
      }
    }
    label31:
    for (int j = 1;; j = 0)
    {
      if ((i ^ j) == 0) {
        break label36;
      }
      return false;
      i = 0;
      break;
    }
    label36:
    if (paramString1 == null) {
      return true;
    }
    return paramString1.equals(paramString2);
  }
  
  public static boolean ao(List<ColorNote> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (i((ColorNote)paramList.next())) {
        return true;
      }
    }
    return false;
  }
  
  public static ColorNote b(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return null;
    }
    int i = gV(paramColorNote.getServiceType());
    return new ColorNote.a().a(i).a(paramColorNote.getSubType()).b(paramColorNote.getMainTitle()).c(paramColorNote.getSubTitle()).a(paramColorNote.getReserve()).a();
  }
  
  public static ColorNote c(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return new ColorNote.a().a();
    }
    return new ColorNote.a().a(paramColorNote.getServiceType()).a(paramColorNote.getSubType()).b(paramColorNote.getMainTitle()).c(paramColorNote.getSubTitle()).d(paramColorNote.getPicUrl()).a(paramColorNote.getReserve()).b(paramColorNote.mExtra).a();
  }
  
  public static int cJ(String paramString)
  {
    int i = 0;
    int j = 0;
    if (aqmr.isEmpty(paramString)) {}
    for (;;)
    {
      return j;
      paramString = Uri.parse(paramString);
      try
      {
        paramString = paramString.getQueryParameter("_wwv");
        if (!aqmr.isEmpty(paramString))
        {
          long l = Long.parseLong(paramString);
          if ((0x20000 & l) != 0L) {
            i = 1;
          }
          j = i;
          if ((0x10000 & l) != 0L) {
            return i + 2;
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("ColorNoteUtils", 1, "parse long error: ", paramString);
      }
    }
    return 0;
  }
  
  public static void ed(Context paramContext)
  {
    aqju localaqju = new aqju(paramContext, 2131756467);
    localaqju.setContentView(2131559151);
    localaqju.dismissMessage();
    ((RelativeLayout.LayoutParams)localaqju.getTitleTextView().getLayoutParams()).bottomMargin = aqnm.dip2px(26.0F);
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.setTitle(paramContext.getString(2131691732));
    localaqju.setNegativeButton(paramContext.getString(2131691731), new aebt(localaqju, paramContext));
    if (localaqju.isShowing()) {
      localaqju.dismiss();
    }
    localaqju.show();
    paramContext = localaqju.getTitleTextView();
    paramContext.setClickable(true);
    paramContext.setFocusable(true);
    paramContext.setFocusableInTouchMode(true);
    aqcl.Q(paramContext, true);
  }
  
  public static void fv(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public static boolean g(ColorNote paramColorNote)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramColorNote != null) {
      if (aqmr.isEmpty(paramColorNote.mMainTitle))
      {
        bool1 = bool2;
        if (aqmr.isEmpty(paramColorNote.mSubTitle)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int gV(int paramInt)
  {
    return 0x7FFFFFFF & paramInt;
  }
  
  public static int gW(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 17039360: 
      return 1;
    case 17104896: 
      return 2;
    case 16908289: 
      return 3;
    }
    return 4;
  }
  
  public static String getTraceInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    localStringBuilder.append("").append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuilder.toString();
  }
  
  public static boolean h(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    while ((paramColorNote.getServiceType() & 0x80000000) == 0) {
      return false;
    }
    return true;
  }
  
  public static boolean i(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {}
    while ((!j(paramColorNote)) || ((paramColorNote.mExtLong & 1L) != 1L)) {
      return false;
    }
    return true;
  }
  
  public static boolean j(ColorNote paramColorNote)
  {
    return paramColorNote.getServiceType() == 17235968;
  }
  
  public static boolean j(List<ColorNote> paramList1, List<ColorNote> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    if (paramList1.size() != paramList2.size()) {
      return false;
    }
    int j = paramList1.size();
    int i = 0;
    while (i < j)
    {
      if (!paramList2.contains((ColorNote)paramList1.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean ja(int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public static boolean jb(int paramInt)
  {
    return (paramInt & 0x1) != 0;
  }
  
  public static String ke(String paramString)
  {
    if (aqmr.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = new Uri.Builder().scheme("webcover").authority(paramString).build().toString();
      return paramString;
    }
    catch (RuntimeException paramString)
    {
      QLog.e("ColorNoteUtils", 1, paramString, new Object[0]);
    }
    return "";
  }
  
  public static boolean lr(String paramString)
  {
    if ((yD == null) || (yD.size() == 0) || (aqmr.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < yD.size())
      {
        String str = (String)yD.get(i);
        if ((str.length() <= paramString.length()) && (paramString.contains(str))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean ls(String paramString)
  {
    if ((yE.size() == 0) || (aqmr.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < yE.size())
      {
        String str = (String)yE.get(i);
        if ((str.length() <= paramString.length()) && (paramString.contains(str))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean lt(String paramString)
  {
    if ((yF.size() == 0) || (aqmr.isEmpty(paramString))) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < yF.size())
      {
        String str = (String)yF.get(i);
        if ((str.length() <= paramString.length()) && (paramString.contains(str))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean lu(String paramString)
  {
    boolean bool = true;
    if (aqmr.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if (avej.tj(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ColorNoteUtils", 2, "This is boodo url ,disable swipe.");
        }
        return true;
      }
      paramString = Uri.parse(paramString);
      try
      {
        paramString = paramString.getQueryParameter("_wv");
        if (aqmr.isEmpty(paramString)) {
          continue;
        }
        long l = Long.parseLong(paramString);
        if ((l & 0x1000) != 0L) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
        return false;
      }
      catch (Exception paramString)
      {
        QLog.e("ColorNoteUtils", 1, "parse long error: ", paramString);
      }
    }
  }
  
  public static boolean lv(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (aqmr.isEmpty(paramString))
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramString.length()) {
        break label43;
      }
      bool1 = bool2;
      if (!Character.isWhitespace(paramString.charAt(i))) {
        break;
      }
      i += 1;
    }
    label43:
    return true;
  }
  
  public static void p(ColorNote paramColorNote)
  {
    int j = 1;
    int i;
    if (!lv(paramColorNote.mMainTitle))
    {
      i = 1;
      if (lv(paramColorNote.mSubTitle)) {
        break label48;
      }
    }
    for (;;)
    {
      if ((j ^ i) != 0)
      {
        if (i == 0) {
          break label53;
        }
        paramColorNote.mSubTitle = paramColorNote.mMainTitle;
      }
      return;
      i = 0;
      break;
      label48:
      j = 0;
    }
    label53:
    paramColorNote.mMainTitle = paramColorNote.mSubTitle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aebs
 * JD-Core Version:    0.7.0.1
 */