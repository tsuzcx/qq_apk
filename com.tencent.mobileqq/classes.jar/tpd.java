import android.app.Activity;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class tpd
  extends uaj
{
  public static String a;
  private SparseArray<tpg> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private BridgeModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private List<twm> jdField_a_of_type_JavaUtilList;
  JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private List<twm> b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "SheetItemClickProcessor";
  }
  
  public tpd(boolean paramBoolean, List<twm> paramList1, List<twm> paramList2, JSONObject paramJSONObject, WeakReference<Activity> paramWeakReference, String paramString, BridgeModule paramBridgeModule)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    BridgeModule.shareCallBackId = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule = paramBridgeModule;
    this.jdField_a_of_type_JavaUtilList = paramList1;
    this.b = paramList2;
    a(this.jdField_a_of_type_JavaLangRefWeakReference, this.jdField_a_of_type_OrgJsonJSONObject);
  }
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      BridgeModule localBridgeModule1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
      localBridgeModule1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
      localJSONObject.put("type", BridgeModule.shareCallBackType);
      localBridgeModule1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
      localBridgeModule1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
      localJSONObject.put("action", BridgeModule.shareCallBackName);
      localBridgeModule1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
      localJSONObject.put("fromCallback", 0);
      localBridgeModule1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
      if (!TextUtils.isEmpty(BridgeModule.shareCallBackId))
      {
        localBridgeModule1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
        BridgeModule localBridgeModule2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
        localBridgeModule1.invokeCallJS(BridgeModule.shareCallBackId, localJSONObject);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "processClick error=" + localJSONException.getMessage());
    }
  }
  
  private void a(int paramInt)
  {
    String str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("rowkey", "");
    int i = this.jdField_a_of_type_OrgJsonJSONObject.optInt("source", -1);
    int j = this.jdField_a_of_type_OrgJsonJSONObject.optInt("report_from", -1);
    String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("vid", "");
    String str3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("algorithmId", "");
    String str4 = this.jdField_a_of_type_OrgJsonJSONObject.optString("articleId", "");
    String str5 = this.jdField_a_of_type_OrgJsonJSONObject.optString("topicId", "");
    if ((j == 4) || (j == 11)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.reportVideoShareClick(str1, str2, i, a(paramInt), b(paramInt), false, j, str3, str4, str5);
    }
  }
  
  private void a(WeakReference<Activity> paramWeakReference, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new tph(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new tpm(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(4, new tpr(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new tpj(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new tpl(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(21, new tpo(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new tpp(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(35, new tpe(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(37, new tpk(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(31, new tpq(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(39, new tpn(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(134, new tpf(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(133, new tps(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
    this.jdField_a_of_type_AndroidUtilSparseArray.put(-111, new tpi(this, (Activity)paramWeakReference.get(), this, paramJSONObject));
  }
  
  private void b(int paramInt)
  {
    Uri.Builder localBuilder = Uri.parse(this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url")).buildUpon();
    if (paramInt == 2) {
      localBuilder.appendQueryParameter("plat_source", "2");
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("share_url", localBuilder.build().toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "processClick error=" + localJSONException.getMessage());
      }
      if (paramInt == 3) {
        localBuilder.appendQueryParameter("plat_source", "3");
      } else if ((paramInt == 9) || (paramInt == 10)) {
        localBuilder.appendQueryParameter("plat_source", "6");
      } else if (paramInt == 13) {
        localBuilder.appendQueryParameter("plat_source", "4");
      }
    }
  }
  
  private boolean b(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.mShareHelper;
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    List localList = this.b;
    int i;
    if (paramInt == 72) {
      i = 2;
    }
    for (;;)
    {
      localObject1 = ((uai)localObject1).a((List)localObject2, localList, i);
      if ((localObject1 != null) && (((twm)localObject1).jdField_a_of_type_Boolean))
      {
        localObject1 = new JSONObject();
        if (paramInt == 72)
        {
          localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
          BridgeModule.shareCallBackName = "qq_friend";
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.shareToFriendUin = paramActionSheetItem.uin;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.shareToFriendUinType = paramActionSheetItem.uinType;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.shareToFriendUinName = paramActionSheetItem.label;
        }
        try
        {
          paramActionSheetItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
          paramActionSheetItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
          ((JSONObject)localObject1).put("type", BridgeModule.shareCallBackType);
          paramActionSheetItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
          paramActionSheetItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
          ((JSONObject)localObject1).put("action", BridgeModule.shareCallBackName);
          paramActionSheetItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
          ((JSONObject)localObject1).put("fromCallback", 0);
          paramActionSheetItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
          if (!TextUtils.isEmpty(BridgeModule.shareCallBackId))
          {
            paramActionSheetItem = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
            localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule;
            paramActionSheetItem.invokeCallJS(BridgeModule.shareCallBackId, localObject1);
          }
          return true;
          i = paramInt;
        }
        catch (JSONException paramActionSheetItem)
        {
          for (;;)
          {
            QLog.e(jdField_a_of_type_JavaLangString, 1, "processClick webhandle error=" + paramActionSheetItem.getMessage());
          }
        }
      }
    }
    return false;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 13: 
      return 0;
    case 2: 
    case 72: 
    case 73: 
      return 1;
    case 5: 
      return 6;
    case 4: 
      return 7;
    case 3: 
      return 2;
    case 9: 
      return 3;
    case 10: 
      return 4;
    case 12: 
      return 5;
    }
    return 8;
  }
  
  public boolean a(int paramInt, @NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (this.jdField_a_of_type_OrgJsonJSONObject == null);
      BridgeModule.shareCallBackType = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.mShareUtils.a(paramInt);
      BridgeModule.shareCallBackName = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.mShareHelper.a(paramInt);
      if ("1".equals(this.jdField_a_of_type_OrgJsonJSONObject.optString("from"))) {
        b(paramInt);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      bool1 = bool2;
    } while (b(paramInt, paramActionSheetItem));
    String str1 = this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url");
    String str2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("aio_share_url");
    String str3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("puin");
    tpg localtpg = (tpg)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localtpg != null) {
      localtpg.a(str1, str2, str3, paramActionSheetItem, paramInt);
    }
    for (;;)
    {
      a();
      a(paramInt);
      return super.a(paramInt, paramActionSheetItem);
      ((tpg)this.jdField_a_of_type_AndroidUtilSparseArray.get(-111)).a(str1, str2, str3, paramActionSheetItem, paramInt);
    }
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 72: 
      return 19;
    case 1: 
      return 3;
    case 11: 
      return 5;
    case 6: 
      return 4;
    case 44: 
      return 7;
    }
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpd
 * JD-Core Version:    0.7.0.1
 */