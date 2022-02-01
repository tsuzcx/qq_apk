import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class abtg
  implements abvo
{
  private abub jdField_a_of_type_Abub;
  private ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
  private QQAppInterface app;
  private abto.b b = new abti(this);
  private boolean bFj;
  aqrd f = new abth(this);
  private Context mContext;
  private float mDensity;
  private int mRoleId;
  private String mUin;
  
  public abtg(abub paramabub, QQAppInterface paramQQAppInterface, Context paramContext, String paramString, ApolloTextureView paramApolloTextureView)
  {
    this.jdField_a_of_type_Abub = paramabub;
    this.mUin = paramString;
    this.app = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = paramApolloTextureView;
    this.mContext = paramContext;
    this.mDensity = paramContext.getResources().getDisplayMetrics().density;
    this.app.addObserver(this.f);
  }
  
  private int aq(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      return 1;
    }
    if (paramInt2 == 9) {
      return 2;
    }
    return 0;
  }
  
  public List<abtz> a(abkd paramabkd)
  {
    Object localObject1 = null;
    if (paramabkd == null) {
      return localObject1;
    }
    label784:
    for (;;)
    {
      ArrayList localArrayList;
      abtz localabtz;
      int i;
      abkd.a locala;
      JSONObject localJSONObject;
      try
      {
        Object localObject3 = paramabkd.in;
        if (localObject3 == null) {
          break;
        }
        localArrayList = new ArrayList();
        localObject3 = ((HashMap)localObject3).entrySet().iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label638;
        }
        localabtz = new abtz();
        localObject1 = (Map.Entry)((Iterator)localObject3).next();
        if (localObject1 == null) {
          continue;
        }
        i = ((Integer)((Map.Entry)localObject1).getKey()).intValue();
        localabtz.crW = i;
        locala = (abkd.a)((Map.Entry)localObject1).getValue();
        if ((locala == null) || (locala.sK == null) || (locala.sK.size() <= 0)) {
          continue;
        }
        localabtz.mTag = aq(locala.tag, locala.feeType);
        localObject1 = new File(abxi.bir + i + "/config.json");
        if (((File)localObject1).exists()) {
          localObject1 = aqhq.fileToBytes((File)localObject1);
        }
      }
      finally {}
      try
      {
        localJSONObject = new JSONObject(new String((byte[])localObject1, "UTF-8"));
        if ((localJSONObject.has("isShowInCard")) && (localJSONObject.getInt("isShowInCard") == 0)) {
          continue;
        }
        localObject1 = localJSONObject.optString("name");
        if (!localJSONObject.has("showName")) {
          break label784;
        }
        if (!TextUtils.isEmpty(localJSONObject.getString("showName"))) {
          break label581;
        }
      }
      catch (Exception localException)
      {
        label581:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ApolloGuestsPresenter", 2, "initTag e=" + localException.toString());
        continue;
      }
      localabtz.mPriority = ((Integer)abkd.iT.get(locala.sK.get(0))).intValue();
      if ((localObject1 != null) && (((String)localObject1).length() > 5))
      {
        localObject1 = ((String)localObject1).substring(0, 4);
        localabtz.mDescription = (abkd.dt[localabtz.mPriority] + (String)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.onGetDressRect((String)locala.sK.get(0));
        if ((localObject1 != null) && ((((RectF)localObject1).bottom != ((RectF)localObject1).top) || (((RectF)localObject1).left != ((RectF)localObject1).right)))
        {
          localabtz.crY = (((int)((RectF)localObject1).top + (int)((RectF)localObject1).bottom) / 2);
          localabtz.csa = ((int)((RectF)localObject1).left);
          localabtz.crZ = ((int)((RectF)localObject1).right);
          localabtz.csb = paramabkd.cpv;
          localabtz.csc = paramabkd.cpw;
          localArrayList.add(localabtz);
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloGuestsPresenter", 2, "item.name =" + localabtz.mDescription + " item.y = " + localabtz.crY + " item.left = " + localabtz.csa + " item.right = " + localabtz.crZ);
            continue;
            localObject1 = null;
            continue;
            localObject1 = localJSONObject.getString("showName");
          }
        }
      }
      else
      {
        continue;
        label638:
        if (localArrayList.size() > 4)
        {
          Collections.sort(localArrayList, new abtj(this));
          i = localArrayList.size() - 1;
          while (i >= 4)
          {
            localArrayList.remove(i);
            i -= 1;
          }
        }
        Collections.sort(localArrayList);
        int j = 0;
        i = 0;
        label702:
        if (j < localArrayList.size())
        {
          ((abtz)localArrayList.get(j)).mDirection = i;
          ((abtz)localArrayList.get(j)).crX = ((int)(123.0F * this.mDensity));
          if (i == 0) {
            i = 1;
          }
        }
        for (;;)
        {
          j += 1;
          break label702;
          if (i == 1)
          {
            i = 0;
            continue;
            Object localObject2 = localArrayList;
            break;
          }
        }
      }
    }
  }
  
  public void cEX()
  {
    int i = 99999;
    if (this.app == null) {
      return;
    }
    int j = this.mContext.getSharedPreferences("cmshow_zan", 0).getInt("apollo_zan_count" + this.mUin, 0);
    String str = String.valueOf(j);
    if (j >= 99999) {
      str = 99999 + "+";
    }
    for (;;)
    {
      this.jdField_a_of_type_Abub.aa(str, i, i);
      ((aqrb)this.app.getBusinessHandler(71)).ag(this.mUin, 256, "myApollo");
      return;
      i = j;
    }
  }
  
  public void cEY()
  {
    if (this.app != null) {
      ((aqrb)this.app.getBusinessHandler(71)).iq(this.mUin, "myApollo");
    }
  }
  
  public void cEZ()
  {
    int j = 0;
    if (this.app == null) {
      return;
    }
    Object localObject1 = ((abhh)this.app.getManager(153)).b(this.mUin);
    int i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ApolloBaseInfo)localObject1).getApolloDress();
      if (localObject1 != null)
      {
        i = ((abkd)localObject1).roleId;
        localObject2 = ((abkd)localObject1).M();
        localObject1 = localObject2;
        if (i > 0)
        {
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            localObject1 = localObject2;
            if (localObject2.length > 0)
            {
              localObject1 = localObject2;
              if (!abvg.a(this.mUin, i, (int[])localObject2, this.app, this.b)) {
                localObject1 = abto.j(i);
              }
            }
          }
        }
        if (i >= 0) {
          break label206;
        }
        i = j;
      }
    }
    label206:
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (localObject1.length > 0) {}
      }
      else
      {
        localObject2 = abto.j(i);
      }
      if (this.jdField_a_of_type_Abub != null) {
        this.jdField_a_of_type_Abub.f((int[])localObject2, i);
      }
      this.mRoleId = i;
      return;
      ((aqrb)this.app.getBusinessHandler(71)).Vx(this.mUin);
      for (;;)
      {
        localObject2 = null;
        i = 0;
        break;
        ((aqrb)this.app.getBusinessHandler(71)).Vx(this.mUin);
      }
    }
  }
  
  public void cFa()
  {
    if (this.bFj) {}
    do
    {
      return;
      localObject = ((abhh)this.app.getManager(153)).b(this.mUin);
    } while ((localObject == null) || (this.jdField_a_of_type_Abub == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null));
    Object localObject = a(((ApolloBaseInfo)localObject).getApolloDress());
    this.jdField_a_of_type_Abub.jdMethod_if((List)localObject);
  }
  
  public void destroy()
  {
    if (this.app != null) {
      this.app.removeObserver(this.f);
    }
    this.bFj = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtg
 * JD-Core Version:    0.7.0.1
 */