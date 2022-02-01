import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.JumpInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.text.TopicSpan;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class mkt
{
  private static Pattern J = Pattern.compile(aqjb.an.pattern() + "|" + aqjb.WEB_URL.pattern(), 2);
  
  public static String V(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy.ugc.Utils", 2, "beforeXml:" + paramString1);
    }
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return paramString1;
      if (Character.codePointCount(paramString1, 0, paramString1.length()) != paramString1.length()) {
        break;
      }
    } while (!paramString1.contains(new String(new char[] { '\024' })));
    StringBuilder localStringBuilder1 = new StringBuilder("[emoji:0x%05x");
    StringBuilder localStringBuilder2 = new StringBuilder("[sysEmo:%03d");
    if (!TextUtils.isEmpty(paramString2))
    {
      localStringBuilder1.append(paramString2);
      localStringBuilder2.append(paramString2);
    }
    localStringBuilder1.append(']');
    localStringBuilder2.append(']');
    paramString2 = null;
    if (QLog.isColorLevel()) {
      paramString2 = new StringBuilder(1024).append("beforeXml start");
    }
    int m = paramString1.length();
    int k = 0;
    String str1 = paramString1;
    if (k < m)
    {
      int n = str1.codePointAt(k);
      String str2;
      int i;
      int j;
      if (n > 65535)
      {
        str2 = str1.substring(k, k + 2);
        paramString1 = String.format(localStringBuilder1.toString(), new Object[] { Integer.valueOf(n) });
        str1 = str1.replace(str2, paramString1);
        k += paramString1.length() - 1;
        m = str1.length();
        i = k;
        j = m;
        paramString1 = str1;
        if (QLog.isColorLevel())
        {
          paramString2.append("\n").append("unicode").append(":").append(n);
          paramString1 = str1;
          j = m;
          i = k;
        }
      }
      for (;;)
      {
        k = i + 1;
        m = j;
        str1 = paramString1;
        break;
        i = k;
        j = m;
        paramString1 = str1;
        if (n == 20)
        {
          i = k;
          j = m;
          paramString1 = str1;
          if (k + 1 < m)
          {
            i = str1.charAt(k + 1);
            paramString1 = str1.substring(k, k + 2);
            str2 = String.format(localStringBuilder2.toString(), new Object[] { Integer.valueOf(i) });
            paramString1 = str1.replace(paramString1, str2);
            i = k + (str2.length() - 1);
            j = paramString1.length();
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("readinjoy.ugc.Utils", 2, paramString2.toString());
    }
    return str1;
  }
  
  public static String W(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    Object localObject2 = new StringBuilder("\\[emoji:0x[a-fA-F0-9]{5}");
    Object localObject1 = new StringBuilder("\\[sysEmo:[0-9]{3}");
    if (!TextUtils.isEmpty(paramString2))
    {
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject1).append(paramString2);
    }
    for (int j = paramString2.length();; j = 0)
    {
      ((StringBuilder)localObject2).append("\\]");
      ((StringBuilder)localObject1).append("\\]");
      localObject2 = Pattern.compile(((StringBuilder)localObject2).toString()).matcher(paramString1);
      StringBuffer localStringBuffer = new StringBuffer();
      paramString2 = null;
      if (QLog.isColorLevel()) {
        paramString2 = new StringBuilder(1024).append("afterXml start");
      }
      for (int i = 0; ((Matcher)localObject2).find(); i = 1)
      {
        i = Integer.valueOf(paramString1.substring(((Matcher)localObject2).start() + 9, ((Matcher)localObject2).end() - 1 - j), 16).intValue();
        if (i > 65535) {
          ((Matcher)localObject2).appendReplacement(localStringBuffer, new String(new int[] { i }, 0, 1));
        }
        if (QLog.isColorLevel()) {
          paramString2.append("\n").append("unicode").append(":").append(i);
        }
      }
      ((Matcher)localObject2).appendTail(localStringBuffer);
      localObject2 = localStringBuffer.toString();
      localObject1 = Pattern.compile(((StringBuilder)localObject1).toString()).matcher((CharSequence)localObject2);
      localStringBuffer = new StringBuffer();
      while (((Matcher)localObject1).find())
      {
        i = Integer.valueOf(((String)localObject2).substring(((Matcher)localObject1).start() + 8, ((Matcher)localObject1).end() - 1 - j), 10).intValue();
        ((Matcher)localObject1).appendReplacement(localStringBuffer, new String(new char[] { '\024' }));
        localStringBuffer.append((char)i);
        i = 1;
      }
      ((Matcher)localObject1).appendTail(localStringBuffer);
      if (QLog.isColorLevel()) {
        QLog.d("readinjoy.ugc.Utils", 2, paramString2.toString());
      }
      if (i == 0) {
        break;
      }
      return localStringBuffer.toString();
    }
  }
  
  private static int a(Spannable paramSpannable, int paramInt1, int paramInt2)
  {
    Matcher localMatcher = J.matcher(paramSpannable.subSequence(paramInt1, paramInt2));
    paramInt2 = 0;
    while (localMatcher.find())
    {
      int i = localMatcher.start() + paramInt1;
      int j = localMatcher.end() + paramInt1;
      String str = paramSpannable.subSequence(i, j).toString();
      paramInt2 += 1;
      paramSpannable.setSpan(new nqk(str), i, j, 0);
    }
    return paramInt2;
  }
  
  public static void a(PublicBaseFragment paramPublicBaseFragment)
  {
    Object localObject = paramPublicBaseFragment.getActivity();
    SystemBarCompact localSystemBarCompact;
    if ((localObject != null) && ((localObject instanceof PublicFragmentActivity)))
    {
      localObject = (PublicFragmentActivity)localObject;
      localSystemBarCompact = ((PublicFragmentActivity)localObject).mSystemBarComp;
      if ((localSystemBarCompact != null) && (paramPublicBaseFragment.needImmersive()) && (paramPublicBaseFragment.needStatusTrans()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(((PublicFragmentActivity)localObject).getAppRuntime())) {
          break label92;
        }
        if ((aqfo.isMIUI()) || (aqfo.isFlyme())) {
          break label80;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    return;
    label80:
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label92:
    if ((Build.VERSION.SDK_INT >= 23) && (!aqfo.isMIUI()) && (!aqfo.isFlyme()))
    {
      ((PublicFragmentActivity)localObject).getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!aqfo.isFlyme())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  public static boolean a(Spannable paramSpannable)
  {
    int m = paramSpannable.length();
    if (m <= 0) {}
    for (;;)
    {
      return false;
      if (aqjb.am.matcher(paramSpannable).find())
      {
        Object localObject = (nqk[])paramSpannable.getSpans(0, m, nqk.class);
        int j;
        int n;
        int i;
        if ((localObject != null) && (localObject.length > 0))
        {
          j = localObject.length;
          n = localObject.length;
          i = 0;
          for (;;)
          {
            k = j;
            if (i >= n) {
              break;
            }
            paramSpannable.removeSpan(localObject[i]);
            i += 1;
          }
        }
        int k = 0;
        localObject = (nqi[])paramSpannable.getSpans(0, m, nqi.class);
        if ((localObject != null) && (localObject.length > 0))
        {
          Arrays.sort((Object[])localObject, new mkt.a(paramSpannable));
          int i2 = localObject.length;
          m = 0;
          i = 0;
          j = 0;
          while (m < i2)
          {
            int i3 = paramSpannable.getSpanStart(localObject[m]);
            int i1 = paramSpannable.getSpanEnd(localObject[m]);
            n = i;
            if (j < i3) {
              n = i + a(paramSpannable, j, i3);
            }
            m += 1;
            j = i1;
            i = n;
          }
        }
        while (a(paramSpannable, j, paramSpannable.length()) + i > k)
        {
          return true;
          i = 0;
          j = 0;
        }
      }
    }
  }
  
  public static boolean a(EditText paramEditText, String paramString, boolean paramBoolean, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    return a(paramEditText, paramString, paramBoolean, false, paramList);
  }
  
  public static boolean a(EditText paramEditText, String paramString, boolean paramBoolean1, boolean paramBoolean2, List<SocializeFeedsInfo.BiuCommentInfo> paramList)
  {
    if (paramEditText == null) {
      return true;
    }
    if (paramBoolean2) {}
    Editable localEditable;
    for (Object localObject = "：";; localObject = "")
    {
      localEditable = paramEditText.getText();
      if ((localEditable != null) && (!TextUtils.isEmpty(localEditable.toString()))) {
        break;
      }
      paramList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), ""));
      return true;
    }
    String str = UUID.randomUUID().toString();
    paramEditText = kxk.es(V(localEditable.toString(), str));
    if (TextUtils.isEmpty(paramEditText))
    {
      paramList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), ""));
      return true;
    }
    nqi[] arrayOfnqi = (nqi[])localEditable.getSpans(0, localEditable.length(), nqi.class);
    if ((arrayOfnqi == null) || (arrayOfnqi.length <= 0))
    {
      if (paramBoolean1) {
        break label607;
      }
      paramEditText = paramEditText.replaceAll("\n|\r\n", "");
    }
    label607:
    for (;;)
    {
      paramList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), anbk.nm(W((String)localObject + paramEditText, str))));
      return true;
      int m = arrayOfnqi.length;
      Arrays.sort(arrayOfnqi, new mkt.a(localEditable));
      paramEditText = anbk.nm(W(localEditable.subSequence(0, localEditable.getSpanStart(arrayOfnqi[0])).toString(), str));
      paramList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), (String)localObject + paramEditText.replaceAll("^\\s+", ""), 0));
      int k = localEditable.length();
      int i = 0;
      if (i < m)
      {
        localObject = arrayOfnqi[i];
        int n = localEditable.getSpanEnd(localObject);
        int j;
        if (i == m - 1)
        {
          j = k;
          label373:
          paramEditText = "";
          if (j - n > 0) {
            paramEditText = anbk.nm(W(localEditable.subSequence(n, j).toString(), str));
          }
          if (!(localObject instanceof AtFriendsSpan)) {
            break label482;
          }
          paramList.add(new SocializeFeedsInfo.BiuCommentInfo(((BiuNicknameSpan)localObject).mUin, Long.valueOf(((BiuNicknameSpan)localObject).mFeedId), paramEditText, 1));
        }
        for (;;)
        {
          i += 1;
          break;
          j = localEditable.getSpanStart(arrayOfnqi[(i + 1)]);
          break label373;
          label482:
          if ((localObject instanceof BiuNicknameSpan))
          {
            paramList.add(new SocializeFeedsInfo.BiuCommentInfo(((BiuNicknameSpan)localObject).mUin, Long.valueOf(((BiuNicknameSpan)localObject).mFeedId), paramEditText, 0));
          }
          else if ((localObject instanceof TopicSpan))
          {
            localObject = ((TopicSpan)localObject).b();
            paramList.add(new SocializeFeedsInfo.BiuCommentInfo(paramString, Long.valueOf(0L), paramEditText, 2, new SocializeFeedsInfo.JumpInfo(((TopicInfo)localObject).cO(), ((TopicInfo)localObject).jS(), ((TopicInfo)localObject).jV())));
          }
          else if (!(localObject instanceof nqj)) {}
        }
      }
      return false;
    }
  }
  
  public static class a
    implements Comparator<Object>
  {
    private Spanned b;
    
    public a(Spanned paramSpanned)
    {
      this.b = paramSpanned;
    }
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      int i = this.b.getSpanStart(paramObject1);
      int j = this.b.getSpanStart(paramObject2);
      if (i > j) {
        return 1;
      }
      if (i < j) {
        return -1;
      }
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mkt
 * JD-Core Version:    0.7.0.1
 */