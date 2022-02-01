import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class qrx
{
  public static SpannableStringBuilder a(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, qrx.a parama)
  {
    if (paramCommentEntry.commentType == 1) {
      return c(paramCommentLikeFeedItem, paramCommentEntry, parama);
    }
    if (paramCommentEntry.commentType == 2) {
      return d(paramCommentLikeFeedItem, paramCommentEntry, parama);
    }
    if (paramCommentEntry.commentType == 5) {
      return c(paramContext, paramCommentLikeFeedItem, paramCommentEntry, parama);
    }
    if (paramCommentEntry.commentType == 4) {
      return a(paramContext, paramCommentLikeFeedItem, paramCommentEntry, parama, true);
    }
    return a(paramCommentLikeFeedItem, paramCommentEntry, parama);
  }
  
  private static SpannableStringBuilder a(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, qrx.a parama, boolean paramBoolean)
  {
    paramContext = ((ptf)psx.a(2)).c(paramCommentEntry.authorUnionId);
    String str3 = a(paramCommentLikeFeedItem, paramContext);
    String str4 = a(paramCommentEntry.authorRole, paramContext);
    String str5 = f(paramContext);
    int i;
    String str6;
    if (!TextUtils.isEmpty(str5))
    {
      i = 1;
      str6 = paramCommentEntry.content;
      if (!aofy.Z(paramCommentEntry.content)) {
        break label511;
      }
    }
    label84:
    label93:
    label125:
    label511:
    for (paramCommentLikeFeedItem = anbk.nn(paramCommentEntry.content);; paramCommentLikeFeedItem = null)
    {
      String str1;
      String str2;
      if (paramBoolean)
      {
        paramContext = acfp.m(2131714667);
        if (i == 0) {
          break label403;
        }
        str1 = "V";
        if (!paramBoolean) {
          break label410;
        }
        str2 = str3 + str1 + str4;
        if (paramCommentLikeFeedItem == null) {
          break label417;
        }
      }
      for (paramCommentLikeFeedItem = new aofr(str2 + paramContext + ": " + paramCommentLikeFeedItem, 3, 16);; paramCommentLikeFeedItem = new SpannableStringBuilder(str2 + paramContext + ": " + str6))
      {
        for (;;)
        {
          i = 0;
          if (paramBoolean)
          {
            i = str3.length();
            a(paramCommentLikeFeedItem, 0, i);
            if (ppg.ID()) {
              a(paramCommentLikeFeedItem, 0, i, -16777216);
            }
            int k = i + str1.length();
            if (i != k) {
              a(paramCommentLikeFeedItem, str5, i, k);
            }
            a(paramCommentLikeFeedItem, 0, k, parama, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
            j = str4.length() + k;
            i = j;
            if (k != j)
            {
              a(paramCommentLikeFeedItem, k, j, -4473925);
              i = j;
            }
          }
          int j = paramContext.length() + i;
          a(paramCommentLikeFeedItem, i, j, -4473925);
          try
          {
            paramContext = paramCommentEntry.getExtraJson().optJSONArray("styles");
            if (paramContext == null) {
              break label472;
            }
            j += ": ".length();
            i = 0;
            while (i < paramContext.length())
            {
              paramCommentEntry = paramContext.optJSONObject(i);
              if (paramCommentEntry.optInt("type") == 1) {
                a(paramCommentLikeFeedItem, paramCommentEntry.optInt("start") + j, paramCommentEntry.optInt("end") + j, -605655);
              }
              i += 1;
            }
            i = 0;
          }
          catch (Exception paramContext)
          {
            if (!QLog.isColorLevel()) {
              break label472;
            }
            QLog.e("Q.qqstory.detail.SpannableStringUtils", 2, "styles error.");
            paramCommentLikeFeedItem.append(" ").append("I");
            a(paramCommentLikeFeedItem, paramCommentLikeFeedItem.length() - "I".length(), paramCommentLikeFeedItem.length(), 2130847329, 15, 15, 3);
            return paramCommentLikeFeedItem;
          }
        }
        paramContext = acfp.m(2131714670);
        break label84;
        str1 = "";
        break label93;
        str2 = "";
        break label125;
      }
    }
  }
  
  private static SpannableStringBuilder a(@NonNull CommentEntry paramCommentEntry)
  {
    String str2 = paramCommentEntry.content;
    String str1 = null;
    if (aofy.Z(paramCommentEntry.content)) {
      str1 = anbk.nn(paramCommentEntry.content);
    }
    String str3 = acfp.m(2131714668);
    if (str1 != null) {}
    for (paramCommentEntry = new aofr(str3 + ": " + str1, 3, 16);; paramCommentEntry = new SpannableStringBuilder(str3 + ": " + str2))
    {
      a(paramCommentEntry, 0, str3.length(), -4473925);
      return paramCommentEntry;
    }
  }
  
  private static SpannableStringBuilder a(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, qrx.a parama)
  {
    Object localObject1 = (ptf)psx.a(2);
    Object localObject3 = ((ptf)localObject1).c(paramCommentEntry.authorUnionId);
    String str2 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject3);
    String str3 = a(paramCommentEntry.authorRole, (QQUserUIItem)localObject3);
    Object localObject2;
    String str1;
    if (paramCommentEntry.isReply())
    {
      localObject2 = ((ptf)localObject1).c(paramCommentEntry.replierUnionId);
      str1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject2);
      localObject1 = a(paramCommentEntry.replierRole, (QQUserUIItem)localObject2);
    }
    for (paramCommentLikeFeedItem = (CommentLikeFeedItem)localObject2;; paramCommentLikeFeedItem = null)
    {
      String str4 = f((QQUserUIItem)localObject3);
      String str5 = f(paramCommentLikeFeedItem);
      int i;
      int j;
      label120:
      String str7;
      String str6;
      if (!TextUtils.isEmpty(str4))
      {
        i = 1;
        if ((!paramCommentEntry.isReply()) || (TextUtils.isEmpty(str5))) {
          break label409;
        }
        j = 1;
        str7 = paramCommentEntry.content;
        paramCommentLikeFeedItem = null;
        if (aofy.Z(paramCommentEntry.content)) {
          paramCommentLikeFeedItem = anbk.nn(paramCommentEntry.content);
        }
        str6 = acfp.m(2131714673);
        if (i == 0) {
          break label415;
        }
        localObject2 = "V";
        label161:
        if (j == 0) {
          break label422;
        }
        localObject3 = "V";
        label170:
        if (!TextUtils.isEmpty(str1)) {
          break label475;
        }
        if (paramCommentLikeFeedItem == null) {
          break label429;
        }
      }
      label409:
      label415:
      label422:
      label429:
      for (paramCommentLikeFeedItem = new aofr(str2 + (String)localObject2 + str3 + ": " + paramCommentLikeFeedItem, 3, 16);; paramCommentLikeFeedItem = new SpannableStringBuilder(str2 + (String)localObject2 + str3 + ": " + str7))
      {
        j = str2.length();
        a(paramCommentLikeFeedItem, 0, j);
        if (ppg.ID()) {
          a(paramCommentLikeFeedItem, 0, j, -16777216);
        }
        i = j + ((String)localObject2).length();
        if (j != i) {
          a(paramCommentLikeFeedItem, str4, j, i);
        }
        a(paramCommentLikeFeedItem, 0, i, parama, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
        j = str3.length() + i;
        parama = paramCommentLikeFeedItem;
        if (i != j)
        {
          a(paramCommentLikeFeedItem, i, j, -4473925);
          parama = paramCommentLikeFeedItem;
        }
        if (paramCommentEntry.status == 2)
        {
          parama.append(" ");
          paramCommentLikeFeedItem = acfp.m(2131714672);
          i = parama.length();
          j = paramCommentLikeFeedItem.length();
          parama.append(paramCommentLikeFeedItem);
          a(parama, i, j + i, -48606);
          i = parama.length();
          j = "[icon]  ".length();
          parama.append("[icon]  ");
          b(parama, i, j + i, 2130849515);
        }
        return parama;
        i = 0;
        break;
        j = 0;
        break label120;
        localObject2 = "";
        break label161;
        localObject3 = "";
        break label170;
      }
      label475:
      if (paramCommentLikeFeedItem != null) {}
      for (paramCommentLikeFeedItem = new aofr(str2 + (String)localObject2 + str3 + str6 + str1 + (String)localObject3 + (String)localObject1 + ": " + paramCommentLikeFeedItem, 3, 14);; paramCommentLikeFeedItem = new SpannableStringBuilder(str2 + (String)localObject2 + str3 + str6 + str1 + (String)localObject3 + (String)localObject1 + ": " + str7))
      {
        j = str2.length();
        a(paramCommentLikeFeedItem, 0, j);
        if (ppg.ID()) {
          a(paramCommentLikeFeedItem, 0, j, -16777216);
        }
        i = j + ((String)localObject2).length();
        if (j != i) {
          a(paramCommentLikeFeedItem, str4, j, i);
        }
        a(paramCommentLikeFeedItem, 0, i, parama, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
        j = str3.length() + i;
        if (i != j) {
          a(paramCommentLikeFeedItem, i, j, -4473925);
        }
        j += str6.length();
        i = j + str1.length();
        a(paramCommentLikeFeedItem, j, i);
        if (ppg.ID()) {
          a(paramCommentLikeFeedItem, j, i, -16777216);
        }
        j = i + ((String)localObject3).length();
        if (i != j) {
          a(paramCommentLikeFeedItem, str5, i, j);
        }
        a(paramCommentLikeFeedItem, i - str1.length(), j, parama, paramCommentEntry.replierUnionId, paramCommentEntry.replierRole);
        i = ((String)localObject1).length() + j;
        parama = paramCommentLikeFeedItem;
        if (j == i) {
          break;
        }
        a(paramCommentLikeFeedItem, j, i, -4473925);
        parama = paramCommentLikeFeedItem;
        break;
      }
      localObject1 = "";
      str1 = null;
    }
  }
  
  public static SpannableStringBuilder a(CommentLikeFeedItem paramCommentLikeFeedItem, List<LikeEntry> paramList, qrx.a parama)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str1 = paramCommentLikeFeedItem.feedId + "_" + paramList.hashCode();
    Object localObject = pre.a().a(str1);
    if ((localObject != null) && ((localObject instanceof SpannableStringBuilder))) {
      return new SpannableStringBuilder((CharSequence)localObject);
    }
    boolean bool;
    if ((paramCommentLikeFeedItem.getOwner() != null) && (paramCommentLikeFeedItem.getOwner().getRelationType() == 2))
    {
      bool = true;
      if (!(paramCommentLikeFeedItem.getOwner() instanceof QQUserUIItem)) {
        break label424;
      }
      paramCommentLikeFeedItem = (QQUserUIItem)paramCommentLikeFeedItem.getOwner();
      if (!bool) {
        break label424;
      }
    }
    label261:
    label392:
    label424:
    for (paramCommentLikeFeedItem = paramCommentLikeFeedItem.qq;; paramCommentLikeFeedItem = null)
    {
      int i = 1;
      int j = 0;
      for (;;)
      {
        if (j < paramList.size())
        {
          LikeEntry localLikeEntry = (LikeEntry)paramList.get(j);
          localObject = ((ptf)psx.a(2)).c(localLikeEntry.unionId);
          if ((localObject == null) || (!((QQUserUIItem)localObject).isAvailable()))
          {
            i = 0;
            j += 1;
            continue;
            bool = false;
            break;
          }
          String str2 = f((QQUserUIItem)localObject);
          int k;
          label220:
          String str3;
          StringBuilder localStringBuilder;
          if (!TextUtils.isEmpty(str2))
          {
            k = 1;
            str3 = a(localLikeEntry.unionId, localLikeEntry.uin, bool, paramCommentLikeFeedItem);
            localStringBuilder = new StringBuilder().append(str3);
            if (k == 0) {
              break label385;
            }
            localObject = "V";
            localStringBuilder = localStringBuilder.append((String)localObject);
            if (j != paramList.size() - 1) {
              break label392;
            }
          }
          for (localObject = "";; localObject = ", ")
          {
            localObject = (String)localObject;
            int m = localSpannableStringBuilder.length();
            int n = ((String)localObject).length() + m;
            localSpannableStringBuilder.append((CharSequence)localObject);
            int i1 = str3.length() + m;
            if (k != 0) {
              a(localSpannableStringBuilder, str2, i1, i1 + 1);
            }
            a(localSpannableStringBuilder, m, n);
            a(localSpannableStringBuilder, m, n, parama, localLikeEntry.unionId);
            break;
            k = 0;
            break label220;
            localObject = "";
            break label261;
          }
        }
      }
      if (i != 0) {
        pre.a().a(str1, localSpannableStringBuilder);
      }
      return new SpannableStringBuilder(localSpannableStringBuilder);
    }
  }
  
  private static String a(int paramInt, QQUserUIItem paramQQUserUIItem)
  {
    if ((paramInt == 0) || (paramInt == 2)) {
      return "";
    }
    if (paramQQUserUIItem == null) {
      return "";
    }
    if (TextUtils.isEmpty(paramQQUserUIItem.nickPostfix)) {
      return "";
    }
    return paramQQUserUIItem.nickPostfix;
  }
  
  private static String a(CommentLikeFeedItem paramCommentLikeFeedItem, QQUserUIItem paramQQUserUIItem)
  {
    int i;
    if ((paramCommentLikeFeedItem instanceof VideoListFeedItem))
    {
      paramCommentLikeFeedItem = (VideoListFeedItem)paramCommentLikeFeedItem;
      if ((paramCommentLikeFeedItem != null) && (paramCommentLikeFeedItem.getOwner() != null) && (paramCommentLikeFeedItem.getOwner().getRelationType() == 2))
      {
        i = 1;
        if ((i == 0) || (!(paramCommentLikeFeedItem.getOwner() instanceof QQUserUIItem))) {
          break label93;
        }
        paramCommentLikeFeedItem = ((QQUserUIItem)paramCommentLikeFeedItem.getOwner()).qq;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        return ((ptc)psx.a(23)).a(paramQQUserUIItem, paramCommentLikeFeedItem, false, false);
        i = 0;
        break;
      }
      return qem.d(paramQQUserUIItem);
      label93:
      paramCommentLikeFeedItem = null;
      continue;
      paramCommentLikeFeedItem = null;
      i = 0;
    }
  }
  
  public static String a(String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    paramString1 = ((ptf)psx.a(2)).c(paramString1);
    if (paramBoolean) {
      return ((ptc)psx.a(23)).a(paramString1, paramString3, false, false);
    }
    return qem.d(paramString1);
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    paramSpannableStringBuilder.setSpan(new StyleSpan(1), paramInt1, paramInt2, 33);
  }
  
  private static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3)
  {
    paramSpannableStringBuilder.setSpan(new ForegroundColorSpan(paramInt3), paramInt1, paramInt2, 33);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    a(paramSpannableStringBuilder, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 2);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramInt4 = rpq.dip2px(BaseApplicationImpl.getContext(), paramInt4);
    paramInt5 = rpq.dip2px(BaseApplicationImpl.getContext(), paramInt5);
    Object localObject = BaseApplicationImpl.getContext().getResources().getDrawable(paramInt3);
    ((Drawable)localObject).setBounds(0, 0, paramInt4, paramInt5);
    if (paramInt6 == 1) {
      localObject = new ImageSpan((Drawable)localObject, 1);
    }
    for (;;)
    {
      paramSpannableStringBuilder.setSpan(localObject, paramInt1, paramInt2, 33);
      return;
      if (paramInt6 == 0) {
        localObject = new ImageSpan((Drawable)localObject, 0);
      } else if (paramInt6 == 3) {
        localObject = new rsf((Drawable)localObject);
      } else {
        localObject = new rsz((Drawable)localObject);
      }
    }
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, qrx.a parama, String paramString)
  {
    a(paramSpannableStringBuilder, paramInt1, paramInt2, parama, paramString, 0);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, qrx.a parama, String paramString, int paramInt3)
  {
    paramSpannableStringBuilder.setSpan(new qry(parama, paramString, paramInt3), paramInt1, paramInt2, 33);
  }
  
  public static void a(SpannableStringBuilder paramSpannableStringBuilder, String paramString, int paramInt1, int paramInt2)
  {
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    if (paramString.getStatus() != 1) {
      paramString.startDownload();
    }
    int i = rpq.dip2px(BaseApplicationImpl.getContext(), 13.0F);
    paramString.setBounds(0, 0, i, i);
    paramSpannableStringBuilder.setSpan(new rsz(paramString), paramInt1, paramInt2, 33);
  }
  
  public static SpannableStringBuilder b(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, qrx.a parama)
  {
    if (paramCommentEntry.commentType == 1) {
      return a(paramCommentEntry);
    }
    if (paramCommentEntry.commentType == 2) {
      return b(paramCommentEntry);
    }
    if (paramCommentEntry.commentType == 5) {
      return c(paramCommentEntry);
    }
    if (paramCommentEntry.commentType == 4) {
      return a(paramContext, paramCommentLikeFeedItem, paramCommentEntry, parama, false);
    }
    return b(paramCommentLikeFeedItem, paramCommentEntry, parama);
  }
  
  private static SpannableStringBuilder b(@NonNull CommentEntry paramCommentEntry)
  {
    String str = acfp.m(2131714669);
    int i = Integer.parseInt(paramCommentEntry.content);
    paramCommentEntry = new SpannableStringBuilder(str + ": " + "A");
    int j = str.length();
    a(paramCommentEntry, 0, j, -4473925);
    j += ": ".length();
    int k = "A".length() + j;
    switch (i)
    {
    default: 
      return paramCommentEntry;
    case 1: 
      a(paramCommentEntry, j, k, 2130845459, 37, 16);
      return paramCommentEntry;
    case 2: 
      a(paramCommentEntry, j, k, 2130845461, 37, 16);
      return paramCommentEntry;
    case 3: 
      a(paramCommentEntry, j, k, 2130845460, 37, 16);
      return paramCommentEntry;
    case 4: 
      a(paramCommentEntry, j, k, 2130845458, 37, 16);
      return paramCommentEntry;
    }
    a(paramCommentEntry, j, k, 2130845457, 37, 16);
    return paramCommentEntry;
  }
  
  private static SpannableStringBuilder b(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, qrx.a parama)
  {
    String str1 = null;
    Object localObject1 = (ptf)psx.a(2);
    Object localObject2;
    String str2;
    if (paramCommentEntry.isReply())
    {
      localObject2 = ((ptf)localObject1).c(paramCommentEntry.replierUnionId);
      localObject1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject2);
      str2 = a(paramCommentEntry.replierRole, (QQUserUIItem)localObject2);
      paramCommentLikeFeedItem = (CommentLikeFeedItem)localObject2;
      localObject2 = str2;
    }
    for (;;)
    {
      str2 = f(paramCommentLikeFeedItem);
      int i;
      String str4;
      String str3;
      if ((paramCommentEntry.isReply()) && (!TextUtils.isEmpty(str2)))
      {
        i = 1;
        str4 = paramCommentEntry.content;
        paramCommentLikeFeedItem = str1;
        if (aofy.Z(paramCommentEntry.content)) {
          paramCommentLikeFeedItem = anbk.nn(paramCommentEntry.content);
        }
        str3 = acfp.m(2131714661);
        if (i == 0) {
          break label153;
        }
        str1 = "V";
      }
      for (;;)
      {
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          if (paramCommentLikeFeedItem != null)
          {
            paramCommentEntry = new aofr(paramCommentLikeFeedItem, 3, 16);
            return paramCommentEntry;
            i = 0;
            break;
            label153:
            str1 = "";
            continue;
          }
          return new SpannableStringBuilder(str4);
        }
      }
      if (paramCommentLikeFeedItem != null) {}
      for (paramCommentLikeFeedItem = new aofr(str3 + (String)localObject1 + str1 + (String)localObject2 + ": " + paramCommentLikeFeedItem, 3, 14);; paramCommentLikeFeedItem = new SpannableStringBuilder(str3 + (String)localObject1 + str1 + (String)localObject2 + ": " + str4))
      {
        int j = str3.length();
        i = ((String)localObject1).length() + j;
        a(paramCommentLikeFeedItem, j, i);
        if (ppg.ID()) {
          a(paramCommentLikeFeedItem, j, i, -16777216);
        }
        j = str1.length() + i;
        if (i != j) {
          a(paramCommentLikeFeedItem, str2, i, j);
        }
        a(paramCommentLikeFeedItem, i - ((String)localObject1).length(), j, parama, paramCommentEntry.replierUnionId, paramCommentEntry.replierRole);
        i = ((String)localObject2).length() + j;
        paramCommentEntry = paramCommentLikeFeedItem;
        if (j == i) {
          break;
        }
        a(paramCommentLikeFeedItem, j, i, -4473925);
        return paramCommentLikeFeedItem;
      }
      localObject2 = "";
      paramCommentLikeFeedItem = null;
      localObject1 = null;
    }
  }
  
  public static void b(SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramSpannableStringBuilder, paramInt1, paramInt2, paramInt3, 15, 15);
  }
  
  private static SpannableStringBuilder c(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, qrx.a parama)
  {
    paramContext = ((ptf)psx.a(2)).c(paramCommentEntry.authorUnionId);
    String str1 = a(paramCommentLikeFeedItem, paramContext);
    String str2 = a(paramCommentEntry.authorRole, paramContext);
    String str3 = f(paramContext);
    int i;
    int j;
    if (!TextUtils.isEmpty(str3))
    {
      i = 1;
      j = paramCommentEntry.atVideoShootTime;
      paramContext = null;
      if (j > 0) {
        paramContext = new SimpleDateFormat("HH:mm").format(Long.valueOf(j * 1000L));
      }
      if (!TextUtils.isEmpty(paramContext)) {
        break label337;
      }
      paramContext = acfp.m(2131714662);
      label100:
      if (i == 0) {
        break label370;
      }
    }
    label337:
    label370:
    for (paramCommentLikeFeedItem = "V";; paramCommentLikeFeedItem = "")
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str1 + paramCommentLikeFeedItem + str2 + ":" + paramContext + "A");
      j = str1.length();
      a(localSpannableStringBuilder, 0, j);
      if (ppg.ID()) {
        a(localSpannableStringBuilder, 0, j, -16777216);
      }
      i = j + paramCommentLikeFeedItem.length();
      if (j != i) {
        a(localSpannableStringBuilder, str3, j, i);
      }
      a(localSpannableStringBuilder, 0, i, parama, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
      j = i + str2.length();
      if (i != j) {
        a(localSpannableStringBuilder, i, j, -4473925);
      }
      i = ":".length() + j + paramContext.length();
      if (j != i) {
        a(localSpannableStringBuilder, j, i, -16777216);
      }
      j = "A".length() + i;
      if (i != j) {
        a(localSpannableStringBuilder, i, j, 2130847329, 15, 15, 3);
      }
      return localSpannableStringBuilder;
      i = 0;
      break;
      paramContext = " @" + paramContext + acfp.m(2131714662);
      break label100;
    }
  }
  
  private static SpannableStringBuilder c(@NonNull CommentEntry paramCommentEntry)
  {
    int i = paramCommentEntry.atVideoShootTime;
    paramCommentEntry = null;
    if (i > 0) {
      paramCommentEntry = new SimpleDateFormat("HH:mm").format(Long.valueOf(i * 1000L));
    }
    if (TextUtils.isEmpty(paramCommentEntry)) {}
    for (paramCommentEntry = acfp.m(2131714666);; paramCommentEntry = "@" + paramCommentEntry + acfp.m(2131714664))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCommentEntry + "A");
      i = paramCommentEntry.length();
      int j = "A".length() + i;
      if (i != j) {
        a(localSpannableStringBuilder, i, j, 2130847329, 15, 15);
      }
      return localSpannableStringBuilder;
    }
  }
  
  private static SpannableStringBuilder c(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, qrx.a parama)
  {
    Object localObject = ((ptf)psx.a(2)).c(paramCommentEntry.authorUnionId);
    String str1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject);
    String str2 = a(paramCommentEntry.authorRole, (QQUserUIItem)localObject);
    String str3 = f((QQUserUIItem)localObject);
    int i;
    String str5;
    String str4;
    if (!TextUtils.isEmpty(str3))
    {
      i = 1;
      str5 = paramCommentEntry.content;
      localObject = null;
      if (aofy.Z(paramCommentEntry.content)) {
        localObject = anbk.nn(paramCommentEntry.content);
      }
      str4 = acfp.m(2131714665);
      if (i == 0) {
        break label272;
      }
      paramCommentLikeFeedItem = "V";
      label95:
      if (localObject == null) {
        break label278;
      }
    }
    label272:
    label278:
    for (localObject = new aofr(str1 + paramCommentLikeFeedItem + str2 + str4 + ": " + (String)localObject, 3, 16);; localObject = new SpannableStringBuilder(str1 + paramCommentLikeFeedItem + str2 + str4 + ": " + str5))
    {
      int j = str1.length();
      a((SpannableStringBuilder)localObject, 0, j);
      if (ppg.ID()) {
        a((SpannableStringBuilder)localObject, 0, j, -16777216);
      }
      i = paramCommentLikeFeedItem.length() + j;
      if (j != i) {
        a((SpannableStringBuilder)localObject, str3, j, i);
      }
      a((SpannableStringBuilder)localObject, 0, i, parama, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
      j = str2.length() + i;
      if (i != j) {
        a((SpannableStringBuilder)localObject, i, j, -4473925);
      }
      a((SpannableStringBuilder)localObject, j, str4.length() + j, -4473925);
      return localObject;
      i = 0;
      break;
      paramCommentLikeFeedItem = "";
      break label95;
    }
  }
  
  private static SpannableStringBuilder d(CommentLikeFeedItem paramCommentLikeFeedItem, @NonNull CommentEntry paramCommentEntry, qrx.a parama)
  {
    Object localObject = ((ptf)psx.a(2)).c(paramCommentEntry.authorUnionId);
    String str1 = a(paramCommentLikeFeedItem, (QQUserUIItem)localObject);
    String str2 = a(paramCommentEntry.authorRole, (QQUserUIItem)localObject);
    localObject = f((QQUserUIItem)localObject);
    int i;
    label52:
    String str3;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = 1;
      str3 = acfp.m(2131714671);
      if (i == 0) {
        break label312;
      }
    }
    SpannableStringBuilder localSpannableStringBuilder;
    int k;
    int j;
    label312:
    for (paramCommentLikeFeedItem = "V";; paramCommentLikeFeedItem = "")
    {
      i = Integer.parseInt(paramCommentEntry.content);
      localSpannableStringBuilder = new SpannableStringBuilder(str1 + paramCommentLikeFeedItem + str2 + str3 + ": " + "A");
      k = str1.length();
      a(localSpannableStringBuilder, 0, k);
      if (ppg.ID()) {
        a(localSpannableStringBuilder, 0, k, -16777216);
      }
      j = k + paramCommentLikeFeedItem.length();
      if (k != j) {
        a(localSpannableStringBuilder, (String)localObject, k, j);
      }
      a(localSpannableStringBuilder, 0, j, parama, paramCommentEntry.authorUnionId, paramCommentEntry.authorRole);
      k = str2.length() + j;
      if (j != k) {
        a(localSpannableStringBuilder, j, k, -4473925);
      }
      j = str3.length() + k;
      a(localSpannableStringBuilder, k, j, -4473925);
      j = ": ".length() + j;
      k = "A".length() + j;
      switch (i)
      {
      default: 
        return localSpannableStringBuilder;
        i = 0;
        break label52;
      }
    }
    a(localSpannableStringBuilder, j, k, 2130845459, 37, 16, 3);
    return localSpannableStringBuilder;
    a(localSpannableStringBuilder, j, k, 2130845461, 37, 16, 3);
    return localSpannableStringBuilder;
    a(localSpannableStringBuilder, j, k, 2130845460, 37, 16, 3);
    return localSpannableStringBuilder;
    a(localSpannableStringBuilder, j, k, 2130845458, 37, 16, 3);
    return localSpannableStringBuilder;
    a(localSpannableStringBuilder, j, k, 2130845457, 37, 16, 3);
    return localSpannableStringBuilder;
  }
  
  private static String f(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null) {
      return null;
    }
    return paramQQUserUIItem.getUserIconUrl();
  }
  
  public static abstract interface a
  {
    public abstract void bs(String paramString, int paramInt);
  }
  
  public static class b
    implements qrx.a
  {
    private CommentLikeFeedItem a;
    private int feedType;
    private boolean isComment;
    private WeakReference<Context> mContextRef;
    
    public b(Context paramContext, CommentLikeFeedItem paramCommentLikeFeedItem, int paramInt, boolean paramBoolean)
    {
      this.mContextRef = new WeakReference(paramContext);
      this.a = paramCommentLikeFeedItem;
      this.feedType = paramInt;
      this.isComment = paramBoolean;
    }
    
    public void b(CommentLikeFeedItem paramCommentLikeFeedItem)
    {
      this.a = paramCommentLikeFeedItem;
    }
    
    public void bs(String paramString, int paramInt)
    {
      ram.b("Q.qqstory.detail.SpannableStringUtils", "on nick click. unionId = %s.", paramString);
      if ((paramInt == 1002) || (paramInt == 1003)) {}
      Object localObject;
      do
      {
        return;
        localObject = (Context)this.mContextRef.get();
        if (localObject != null) {
          ppf.f((Context)localObject, 12, paramString);
        }
      } while (this.a == null);
      if (this.isComment)
      {
        localObject = "clk_reply_nick";
        paramString = "2";
        if (!(this.a instanceof VideoListFeedItem)) {
          break label157;
        }
        paramString = (VideoListFeedItem)this.a;
        paramInt = rar.a(paramString);
        if (!paramString.getOwner().isMe()) {
          break label151;
        }
        paramString = "1";
      }
      for (;;)
      {
        rar.a("home_page", (String)localObject, paramInt, 0, new String[] { paramString, rar.bX(this.feedType), "", this.a.feedId });
        return;
        localObject = "clk_like_name";
        break;
        label151:
        paramString = "2";
        continue;
        label157:
        paramInt = 4;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qrx
 * JD-Core Version:    0.7.0.1
 */