import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusAnimationItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusRecommendItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class tia
  extends tgr
{
  private SparseArray<tir> jdField_a_of_type_AndroidUtilSparseArray;
  private Container jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private tir jdField_a_of_type_Tir;
  
  public tia(thz paramthz, View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    if ((paramView instanceof Container)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer = ((Container)paramView);
    }
    b();
  }
  
  private String a(JSONObject paramJSONObject)
  {
    String str2 = "";
    String str1 = str2;
    if (paramJSONObject.opt("card_info") != null) {}
    try
    {
      paramJSONObject = paramJSONObject.getJSONObject("card_info");
      str1 = str2;
      if (paramJSONObject.opt("rowKey") != null) {
        str1 = paramJSONObject.getString("rowKey");
      }
      return str1;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return "";
  }
  
  private tir a()
  {
    return new tij(this);
  }
  
  private tir a(int paramInt)
  {
    tir localtir = (tir)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localtir != null) {
      return localtir;
    }
    return j();
  }
  
  private void a(Context paramContext, ProteusItemData paramProteusItemData)
  {
    ViewFactory.findClickableViewListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), new tib(this, paramContext, paramProteusItemData));
  }
  
  private void a(View paramView, BaseData paramBaseData)
  {
    if ((paramView == null) || (paramBaseData == null)) {}
    for (;;)
    {
      return;
      try
      {
        ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
        if (((ProteusItemData)paramBaseData).u == 1)
        {
          paramView.setOnLongClickListener(new tig(this, paramView, localProteusItemData));
          return;
        }
      }
      catch (Exception paramView)
      {
        QLog.d("WebProteusViewCreator", 1, "addLongClickListener error,msg:" + paramView.toString());
      }
    }
  }
  
  /* Error */
  private void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 146	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:c	Lorg/json/JSONObject;
    //   4: astore 4
    //   6: aload_1
    //   7: invokevirtual 151	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getEventAttachedData	()Ljava/lang/String;
    //   10: astore 5
    //   12: aload_0
    //   13: aload 4
    //   15: invokespecial 153	tia:a	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   18: astore 6
    //   20: aload_0
    //   21: invokespecial 156	tia:a	()Z
    //   24: ifeq +17 -> 41
    //   27: aload_0
    //   28: aload_1
    //   29: aload_2
    //   30: aload_3
    //   31: aload 5
    //   33: aload 4
    //   35: aload 6
    //   37: invokespecial 159	tia:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase;Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   40: return
    //   41: new 161	tjl
    //   44: dup
    //   45: aload 4
    //   47: ldc 163
    //   49: invokevirtual 166	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   52: aload 6
    //   54: invokespecial 169	tjl:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: astore 5
    //   59: aload 5
    //   61: getfield 172	tjl:a	Ljava/lang/String;
    //   64: aload 6
    //   66: ldc 174
    //   68: invokestatic 179	oqt:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 182	oqt:a	(Ljava/lang/String;)V
    //   74: invokestatic 187	bjjq:a	()Lbjjq;
    //   77: aload 5
    //   79: getfield 189	tjl:b	Ljava/lang/String;
    //   82: invokevirtual 192	bjjq:b	(Ljava/lang/String;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   85: astore 7
    //   87: aload 7
    //   89: ifnonnull +193 -> 282
    //   92: aload 5
    //   94: getfield 172	tjl:a	Ljava/lang/String;
    //   97: aload 6
    //   99: ldc 194
    //   101: invokestatic 179	oqt:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   104: invokestatic 182	oqt:a	(Ljava/lang/String;)V
    //   107: aload 5
    //   109: getfield 172	tjl:a	Ljava/lang/String;
    //   112: aload 6
    //   114: ldc 196
    //   116: invokestatic 179	oqt:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   119: invokestatic 182	oqt:a	(Ljava/lang/String;)V
    //   122: new 198	com/tencent/open/downloadnew/DownloadInfo
    //   125: dup
    //   126: invokespecial 199	com/tencent/open/downloadnew/DownloadInfo:<init>	()V
    //   129: astore 6
    //   131: aload 6
    //   133: aload 5
    //   135: getfield 189	tjl:b	Ljava/lang/String;
    //   138: putfield 201	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   141: aload 6
    //   143: ldc 203
    //   145: putfield 206	com/tencent/open/downloadnew/DownloadInfo:m	Ljava/lang/String;
    //   148: aload 6
    //   150: ldc 208
    //   152: putfield 211	com/tencent/open/downloadnew/DownloadInfo:e	Ljava/lang/String;
    //   155: invokestatic 187	bjjq:a	()Lbjjq;
    //   158: aload 6
    //   160: invokevirtual 214	bjjq:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   163: aload 4
    //   165: ldc 216
    //   167: invokevirtual 45	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   170: astore 6
    //   172: aload 6
    //   174: ldc 218
    //   176: ldc 220
    //   178: invokevirtual 224	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   181: pop
    //   182: aload 6
    //   184: ldc 226
    //   186: iconst_0
    //   187: invokevirtual 229	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   190: pop
    //   191: aload_0
    //   192: getfield 16	tia:jdField_a_of_type_Thz	Lthz;
    //   195: invokestatic 234	thz:a	(Lthz;)Landroid/widget/BaseAdapter;
    //   198: ifnull +13 -> 211
    //   201: aload_0
    //   202: getfield 16	tia:jdField_a_of_type_Thz	Lthz;
    //   205: invokestatic 234	thz:a	(Lthz;)Landroid/widget/BaseAdapter;
    //   208: invokevirtual 239	android/widget/BaseAdapter:notifyDataSetChanged	()V
    //   211: aload 5
    //   213: getfield 240	tjl:d	Ljava/lang/String;
    //   216: ifnull +24 -> 240
    //   219: aload 5
    //   221: getfield 240	tjl:d	Ljava/lang/String;
    //   224: astore 5
    //   226: aload_2
    //   227: ldc 242
    //   229: invokevirtual 247	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   232: checkcast 249	android/content/ClipboardManager
    //   235: aload 5
    //   237: invokevirtual 253	android/content/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   240: aload_3
    //   241: getfield 256	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusItemData:a	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   244: aload_1
    //   245: invokevirtual 259	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   248: invokestatic 264	tkj:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;Ljava/lang/String;)Lorg/json/JSONObject;
    //   251: astore_2
    //   252: aload_3
    //   253: instanceof 266
    //   256: ifeq +69 -> 325
    //   259: aload_1
    //   260: invokevirtual 259	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   263: aload_3
    //   264: checkcast 266	com/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData
    //   267: aload_2
    //   268: invokestatic 269	tkj:a	(Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/ProteusRecommendItemData;Lorg/json/JSONObject;)V
    //   271: return
    //   272: astore 6
    //   274: aload 6
    //   276: invokevirtual 54	org/json/JSONException:printStackTrace	()V
    //   279: goto -68 -> 211
    //   282: aload_0
    //   283: aload 7
    //   285: aload 4
    //   287: aload 6
    //   289: invokespecial 272	tia:a	(Lcom/tencent/open/downloadnew/DownloadInfo;Lorg/json/JSONObject;Ljava/lang/String;)V
    //   292: goto -81 -> 211
    //   295: astore_2
    //   296: ldc 118
    //   298: iconst_1
    //   299: new 120	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   306: ldc_w 274
    //   309: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_2
    //   313: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 279	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: goto -82 -> 240
    //   325: aload_1
    //   326: invokevirtual 259	com/tencent/biz/pubaccount/readinjoy/view/proteus/virtualview/core/ViewBase:getName	()Ljava/lang/String;
    //   329: aload 4
    //   331: aload_2
    //   332: invokestatic 282	tkj:a	(Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;)V
    //   335: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	tia
    //   0	336	1	paramViewBase	ViewBase
    //   0	336	2	paramContext	Context
    //   0	336	3	paramProteusItemData	ProteusItemData
    //   4	326	4	localJSONObject	JSONObject
    //   10	226	5	localObject1	Object
    //   18	165	6	localObject2	Object
    //   272	16	6	localJSONException	JSONException
    //   85	199	7	localDownloadInfo	DownloadInfo
    // Exception table:
    //   from	to	target	type
    //   163	211	272	org/json/JSONException
    //   226	240	295	java/lang/Throwable
  }
  
  private void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    tjl localtjl = new tjl(paramJSONObject.optString("kd_ug_rsp_info"), paramString2);
    oqt.a(oqt.a(localtjl.a, paramString2, "3"));
    oqt.a(oqt.a(localtjl.a, paramString2, "7"));
    if (!TextUtils.isEmpty(localtjl.c))
    {
      paramString2 = new Intent();
      paramString2.setAction("android.intent.action.VIEW");
      paramString2.putExtra("big_brother_source_key", "biz_src_kandian_read");
      paramString2.setData(Uri.parse(localtjl.c));
      if (six.a(paramContext, paramString2)) {
        paramContext.startActivity(paramString2);
      }
    }
    paramContext = tkj.a(paramProteusItemData.a, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      tkj.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "onClick,schema=" + paramString1 + " viewID=" + paramViewBase.getName());
      return;
      tkj.a(paramViewBase.getName(), paramJSONObject, paramContext);
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, JSONObject paramJSONObject, String paramString)
  {
    JSONObject localJSONObject;
    try
    {
      localJSONObject = paramJSONObject.getJSONObject("id_recommend_category_txt");
      paramJSONObject = new tjl(paramJSONObject.optString("kd_ug_rsp_info"), paramString);
      if (paramDownloadInfo.a() == 4)
      {
        oqt.a(oqt.a(paramJSONObject.a, paramString, "20"));
        if (bjjq.a().a(paramDownloadInfo)) {
          return;
        }
        bjjq.a().b(paramDownloadInfo);
        return;
      }
      if (a(paramDownloadInfo.a()))
      {
        bjjq.a().a(paramJSONObject.b);
        oqt.a(oqt.a(paramJSONObject.a, paramString, "22"));
        return;
      }
    }
    catch (JSONException paramDownloadInfo)
    {
      paramDownloadInfo.printStackTrace();
      return;
    }
    oqt.a(oqt.a(paramJSONObject.a, paramString, "10"));
    bjjq.a().b(paramDownloadInfo);
    localJSONObject.put("text", paramJSONObject.h + paramDownloadInfo.f + "%");
    localJSONObject.put("label_ug_progress_progress", paramDownloadInfo.f);
    if (thz.a(this.jdField_a_of_type_Thz) != null) {
      thz.a(this.jdField_a_of_type_Thz).notifyDataSetChanged();
    }
  }
  
  private boolean a()
  {
    return !bhfn.a(BaseApplicationImpl.getContext(), "com.tencent.reading").equals("0");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 30) || (paramInt == 10) || (paramInt == 20) || (paramInt == 1) || (paramInt == 2);
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      Object localObject = paramJSONObject.optString("kd_ug_rsp_info");
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = new tjl((String)localObject, a(paramJSONObject));
        bool1 = bool2;
        if (paramJSONObject.opt("id_recommend_category_txt") != null)
        {
          bool1 = bool2;
          if (paramJSONObject.opt("kd_ug_download_url") != null)
          {
            bool1 = bool2;
            if (((tjl)localObject).c != null) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private tir b()
  {
    return new tik(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Tir = null;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1012, a());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1023, b());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1002, c());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1001, d());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1157, e());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1153, f());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1156, g());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1169, h());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1038, h());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1040, i());
    j();
  }
  
  private void b(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    JSONObject localJSONObject = paramProteusItemData.c;
    String str2 = paramViewBase.getEventAttachedData();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = pqx.a(str2, localJSONObject);
      pqx.a(paramContext, str1);
    }
    paramContext = tkj.a(paramProteusItemData.a, paramViewBase.getName());
    if ((paramProteusItemData instanceof ProteusRecommendItemData)) {
      tkj.a(paramViewBase.getName(), (ProteusRecommendItemData)paramProteusItemData, paramContext);
    }
    for (;;)
    {
      QLog.d("WebProteusViewCreator", 1, "[defaultUrlJump], schema = " + str1 + ", viewID = " + paramViewBase.getName());
      return;
      tkj.a(paramViewBase.getName(), localJSONObject, paramContext);
    }
  }
  
  private tir c()
  {
    return new til(this);
  }
  
  private tir d()
  {
    return new tin(this);
  }
  
  private tir e()
  {
    return new tio(this);
  }
  
  private tir f()
  {
    return new tip(this);
  }
  
  private tir g()
  {
    return new tiq(this);
  }
  
  private tir h()
  {
    return new tid(this);
  }
  
  private tir i()
  {
    return new tie(this);
  }
  
  private tir j()
  {
    if (this.jdField_a_of_type_Tir == null) {
      this.jdField_a_of_type_Tir = new tif(this);
    }
    return this.jdField_a_of_type_Tir;
  }
  
  public void b(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer == null) || (paramBaseData2 == null)) {}
    for (;;)
    {
      return;
      if (!(paramBaseData2 instanceof ProteusItemData)) {
        continue;
      }
      paramBaseData1 = (ProteusItemData)paramBaseData2;
      TemplateBean localTemplateBean = paramBaseData1.a;
      if (localTemplateBean != null) {
        thz.a(this.jdField_a_of_type_Thz, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer);
      }
      try
      {
        localTemplateBean.bindData(paramBaseData1.c);
        piv.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getVirtualView(), paramBaseData1.a.getViewBean());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData = paramBaseData1;
        QLog.d("WebProteusViewCreator", 1, "bindWebProteusViewCreator: " + paramBaseData1.c);
        label106:
        a(thz.a(this.jdField_a_of_type_Thz), paramBaseData1);
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer, paramBaseData2);
        if (!(paramBaseData2 instanceof ProteusAnimationItemData)) {
          continue;
        }
        ((ProteusAnimationItemData)paramBaseData2).a(this.jdField_a_of_type_AndroidViewView);
        return;
      }
      catch (Exception localException)
      {
        break label106;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tia
 * JD-Core Version:    0.7.0.1
 */