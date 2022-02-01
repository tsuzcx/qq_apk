import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.emosm.EmosmPb.SmallYellowItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class afqr
  extends afmi
{
  public static final String bEI = acfp.m(2131715096);
  public static final String bEJ = acfp.m(2131715099);
  public static final String bEK = acfp.m(2131715098);
  public static final int cTs;
  public int ahx;
  public boolean cam;
  public int code;
  public String title;
  
  static
  {
    int j = afme.cRU / 20;
    if (afme.cRU % 20 == 0) {}
    for (int i = 0;; i = 1)
    {
      cTs = i + j;
      return;
    }
  }
  
  public afqr(int paramInt1, int paramInt2, int paramInt3, String paramString, boolean paramBoolean)
  {
    this.type = paramInt1;
    this.ahx = paramInt2;
    this.code = paramInt3;
    this.title = paramString;
    this.cam = paramBoolean;
  }
  
  public static List<afom> a(int paramInt, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new afqr(7, 3, -1, bEK, false));
      i += 1;
    }
    i = 0;
    while (i < paramArrayList.size())
    {
      localArrayList.add(new afqr(7, 2, ((Integer)paramArrayList.get(i)).intValue(), "", false));
      i += 1;
    }
    int j = paramArrayList.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new afqr(7, 2, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<afom> a(int paramInt, boolean paramBoolean, ArrayList<Integer> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new afqr(7, 3, -1, bEJ, false));
      i += 1;
    }
    i = 0;
    int k = paramArrayList.size();
    int j = 0;
    if (j < k)
    {
      if ((paramBoolean) && (((Integer)paramArrayList.get(j)).intValue() > 255)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (((Integer)paramArrayList.get(j)).intValue() == -1) {
          localArrayList.add(new afqr(7, 1, 0, "", false));
        } else {
          localArrayList.add(new afqr(7, 1, ((Integer)paramArrayList.get(j)).intValue(), "", false));
        }
      }
    }
    j = (paramArrayList.size() - i) % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        localArrayList.add(new afqr(7, 1, -1, "", false));
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static List<afom> a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList1 = afky.cV();
    ArrayList localArrayList2 = afku.cV();
    ArrayList localArrayList3 = new ArrayList(localArrayList1.size() + localArrayList2.size());
    if (paramBoolean1)
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        localArrayList3.addAll(b((QQAppInterface)localAppRuntime, paramInt, paramBoolean3));
      }
    }
    localArrayList3.addAll(a(paramInt, paramBoolean3, localArrayList1));
    if (paramBoolean2) {
      localArrayList3.addAll(a(paramInt, localArrayList2));
    }
    return localArrayList3;
  }
  
  public static List<afom> a(QQAppInterface paramQQAppInterface, int paramInt, int[] paramArrayOfInt)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      return null;
    }
    if (paramArrayOfInt != null)
    {
      paramQQAppInterface = paramArrayOfInt;
      if (paramArrayOfInt.length != 0) {}
    }
    else
    {
      paramQQAppInterface = afqv.Q();
    }
    paramArrayOfInt = new ArrayList(paramQQAppInterface.length);
    int i = 0;
    while (i < paramQQAppInterface.length)
    {
      paramArrayOfInt.add(Integer.valueOf(paramQQAppInterface[i]));
      i += 1;
    }
    paramQQAppInterface = new ArrayList(paramArrayOfInt.size());
    int j = paramArrayOfInt.size();
    i = 0;
    if (i < j)
    {
      Integer localInteger = (Integer)paramArrayOfInt.get(i);
      if (aofy.jq(localInteger.intValue())) {}
      for (;;)
      {
        i += 1;
        break;
        if (localInteger.intValue() == -1) {
          paramQQAppInterface.add(new afqr(7, 1, 0, "", false));
        } else {
          paramQQAppInterface.add(new afqr(7, 1, localInteger.intValue(), "", false));
        }
      }
    }
    j = paramQQAppInterface.size() % paramInt;
    if (j > 0)
    {
      i = 0;
      while (i < paramInt - j)
      {
        paramQQAppInterface.add(new afqr(7, 1, -1, "", false));
        i += 1;
      }
    }
    return paramQQAppInterface;
  }
  
  public static List<afom> a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "getEmoticonList app = null");
      paramQQAppInterface = null;
    }
    ArrayList localArrayList2;
    ArrayList localArrayList1;
    do
    {
      return paramQQAppInterface;
      ArrayList localArrayList3 = afky.cV();
      localArrayList2 = afku.cV();
      localArrayList1 = new ArrayList(localArrayList3.size() + localArrayList2.size());
      if ((paramInt2 != 2) && (paramInt2 != 3)) {
        localArrayList1.addAll(b(paramQQAppInterface, paramInt1, paramBoolean));
      }
      localArrayList1.addAll(a(paramInt1, paramBoolean, localArrayList3));
      paramQQAppInterface = localArrayList1;
    } while (paramInt2 == 2);
    localArrayList1.addAll(a(paramInt1, localArrayList2));
    return localArrayList1;
  }
  
  public static List<afom> b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return a(paramQQAppInterface, false, 7, paramInt);
  }
  
  public static List<afom> b(QQAppInterface paramQQAppInterface, int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramQQAppInterface == null) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramInt)
    {
      localArrayList.add(new afqr(7, 3, -1, bEI, false));
      i += 1;
    }
    paramQQAppInterface = ((afmb)paramQQAppInterface.getManager(172)).eL();
    int j;
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 1))
    {
      j = 0;
      i = 0;
      if ((j >= paramQQAppInterface.size()) || (i >= paramInt * 3))
      {
        if (i >= paramInt * 3) {
          break label269;
        }
        j = i % paramInt;
        if (j == 0) {
          break label269;
        }
        i = 0;
      }
    }
    while (i < paramInt - j)
    {
      localArrayList.add(new afqr(7, 1, -1, "", false));
      i += 1;
      continue;
      EmosmPb.SmallYellowItem localSmallYellowItem = (EmosmPb.SmallYellowItem)paramQQAppInterface.get(j);
      int k = 1;
      if (localSmallYellowItem.type.get() == 2) {
        k = 2;
      }
      if ((paramBoolean) && (k == 1) && (localSmallYellowItem.id.get() > 255)) {}
      for (;;)
      {
        j += 1;
        break;
        localArrayList.add(new afqr(7, k, localSmallYellowItem.id.get(), "", true));
        i += 1;
      }
      QLog.e("SystemAndEmojiEmoticonInfo", 1, "CommonlyUsedSystemEmoji IS NULL");
    }
    label269:
    return localArrayList;
  }
  
  public static List<afmi> b(int[] paramArrayOfInt)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length + afme.cRU);
    int j = afme.cRU % 20;
    int i = afme.cRU - 1;
    while (i >= afme.cRU - j)
    {
      localArrayList.add(new afqr(7, 2, i, "", false));
      i -= 1;
    }
    i = 0;
    while (i < 20 - j)
    {
      localArrayList.add(new afqr(7, 2, -1, "", false));
      i += 1;
    }
    i = afme.cRU - j - 1;
    if (i >= 0)
    {
      if (afkv.a().a(2).jn(i)) {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(i), " ,type:", Integer.valueOf(2) });
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        localArrayList.add(new afqr(7, 2, i, "", false));
      }
    }
    j = paramArrayOfInt.length;
    i = 0;
    if (i < j)
    {
      int k = paramArrayOfInt[i];
      if (afkv.a().a(1).jn(k)) {
        if (QLog.isColorLevel()) {
          QLog.d("SystemAndEmojiEmoticonInfo", 2, new Object[] { "getOldEmoticonList hided:", Integer.valueOf(k), " ,type:", Integer.valueOf(1) });
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(new afqr(7, 1, k, "", false));
      }
    }
    return localArrayList;
  }
  
  public static void cP(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = b(paramQQAppInterface, 0);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      int i = 0;
      while ((i < 84) && (i < paramQQAppInterface.size()))
      {
        Object localObject = (afom)paramQQAppInterface.get(i);
        if ((localObject instanceof afqr))
        {
          localObject = (afqr)localObject;
          if ((((afqr)localObject).type != 3) && (((afqr)localObject).code != -1))
          {
            localObject = (URLDrawable)((afqr)localObject).b(false);
            if ((localObject != null) && (((URLDrawable)localObject).getStatus() != 1)) {
              ((URLDrawable)localObject).startDownload();
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public static final int d(int[] paramArrayOfInt)
  {
    return (paramArrayOfInt.length + 19) / 20;
  }
  
  public Drawable a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((1 == this.ahx) && (this.code != -1)) {
      localObject1 = afky.z(paramInt);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (2 != this.ahx);
      localObject1 = localObject2;
    } while (this.code == -1);
    return afku.x(paramInt);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if (this.code == -1) {
      return;
    }
    int i = paramEditText.getSelectionStart();
    int j = paramEditText.getSelectionEnd();
    Editable localEditable = paramEditText.getEditableText();
    if (this.ahx == 1) {}
    for (paramContext = aofy.fx(this.code);; paramContext = aofy.fw(this.code))
    {
      localEditable.replace(i, j, paramContext);
      paramEditText.requestFocus();
      o(paramQQAppInterface, paramSessionInfo);
      if (this.cam) {
        anot.a(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800717F", 0, 0, this.ahx + "", this.code + "", "", "");
      }
      if ((paramQQAppInterface != null) && (aofy.jq(this.code)) && (paramSessionInfo != null)) {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "0X800812C", ApolloUtil.gi(paramSessionInfo.cZ), 0, new String[] { String.valueOf(this.code), String.valueOf(abhh.x(paramQQAppInterface)) });
      }
      afkv.a().a(this.ahx).hL(this.code, 1);
      return;
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    return a(this.code, true);
  }
  
  public Drawable b(boolean paramBoolean)
  {
    return a(this.code, paramBoolean);
  }
  
  public Drawable c(Context paramContext, float paramFloat)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((this.ahx == 1) && (this.code != -1)) {
      localObject1 = aofy.b(this.code, true);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.ahx != 2);
      localObject1 = localObject2;
    } while (this.code == -1);
    return super.c(paramContext, paramFloat);
  }
  
  public void o(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    EmosmPb.SmallYellowItem localSmallYellowItem = new EmosmPb.SmallYellowItem();
    localSmallYellowItem.id.set(this.code);
    if (this.ahx == 1) {}
    for (int i = 1;; i = 2)
    {
      localSmallYellowItem.type.set(i);
      long l = System.currentTimeMillis();
      localSmallYellowItem.ts.set(l);
      String str2 = "";
      String str1 = str2;
      if (paramSessionInfo != null)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(paramSessionInfo.troopUin)) {
          str1 = paramSessionInfo.troopUin;
        }
      }
      QLog.d("SystemAndEmojiEmoticonInfo", 1, "send saveemoji type = " + i + ";id = " + this.code + ";ts = " + l + ";troopUin = " + str1);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = (afmb)paramQQAppInterface.getManager(172);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.a(localSmallYellowItem);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afqr
 * JD-Core Version:    0.7.0.1
 */