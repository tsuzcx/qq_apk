import android.graphics.Color;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBase;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.biz.qqstory.utils.JsonORM.a;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import com.tencent.biz.qqstory.view.widget.QQStoryPullToRefreshListView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ayic
  extends aygy
  implements View.OnClickListener, ayig, aytb, AdapterView.c
{
  private ayic.b jdField_a_of_type_Ayic$b;
  private aytc jdField_a_of_type_Aytc;
  private SparseArray<aysy> aY = new SparseArray();
  private QQStoryPullToRefreshListView b;
  private int bqy;
  private boolean dzn;
  private PressDarkImageButton g;
  private int isVip;
  private View mEmptyView;
  private EntityManager mEntityManager = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
  private View mLoadingView;
  private View mRootView;
  private ViewStub n;
  private ImageView nk;
  private List<rmw> oE;
  private View oS;
  private View oT;
  private View oU;
  private TextView qF;
  private TextView yt;
  private TextView yu;
  private TextView yv;
  
  public ayic(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private ayic.a a()
  {
    ayic.a locala = new ayic.a();
    aydu localaydu = (aydu)a(aydu.class);
    if (localaydu != null) {
      localaydu.a(locala);
    }
    return locala;
  }
  
  @Nonnull
  private aysy a(int paramInt)
  {
    Object localObject2 = (aysy)this.aY.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new aysy(this, this.mEntityManager);
      ((aysy)localObject1).reset();
      if (this.jdField_a_of_type_Ayic$b != null)
      {
        localObject2 = new rmw(new rmw.a(this.jdField_a_of_type_Ayic$b.id, this.jdField_a_of_type_Ayic$b.name, this.jdField_a_of_type_Ayic$b.desc, this.jdField_a_of_type_Ayic$b.type), this.jdField_a_of_type_Ayic$b.joinCount, this.jdField_a_of_type_Ayic$b.wording);
        ((aysy)localObject1).ck().add(localObject2);
        ((aysy)localObject1).a((rmw)localObject2);
      }
      this.aY.put(paramInt, localObject1);
    }
    return localObject1;
  }
  
  private void a(@Nullable rmw paramrmw, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.oU.setVisibility(8);
      this.oT.setVisibility(8);
      return;
    }
    if (paramrmw == null)
    {
      this.oU.setVisibility(8);
      this.oT.setVisibility(0);
      return;
    }
    this.oT.setVisibility(8);
    this.oU.setVisibility(0);
    this.yv.setText(paramrmw.a.name);
  }
  
  private void bsk()
  {
    if (this.mRootView == null)
    {
      this.mRootView = this.n.inflate();
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView = ((QQStoryPullToRefreshListView)this.mRootView.findViewById(2131379219));
      this.yt = ((TextView)this.mRootView.findViewById(2131369579));
      this.yu = ((TextView)this.mRootView.findViewById(2131369587));
      this.mEmptyView = this.mRootView.findViewById(2131366438);
      this.oS = this.mRootView.findViewById(2131377231);
      this.oS.setOnClickListener(this);
      this.mLoadingView = this.mRootView.findViewById(2131370820);
      this.oT = this.mRootView.findViewById(2131368529);
      this.oU = this.mRootView.findViewById(2131364609);
      this.yv = ((TextView)this.mRootView.findViewById(2131364608));
      this.nk = ((ImageView)this.mRootView.findViewById(2131365713));
      this.nk.setOnClickListener(this);
      this.jdField_a_of_type_Aytc = new aytc(getContext());
      btl();
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.jdField_a_of_type_Aytc);
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new ayid(this));
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new ayie(this));
      this.yt.setOnClickListener(this);
      this.yu.setOnClickListener(this);
    }
  }
  
  private void btl()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.e.setHeaderBgColor(0);
    int i = Color.parseColor("#7d7d7d");
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.e.setTextColor(i, i, i, i, i);
  }
  
  private void btv()
  {
    this.oS.setVisibility(0);
    this.mEmptyView.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
    this.mLoadingView.setVisibility(8);
  }
  
  private void btw()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(0);
    this.mEmptyView.setVisibility(8);
    this.oS.setVisibility(8);
    this.mLoadingView.setVisibility(8);
  }
  
  private void btx()
  {
    Object localObject = a(this.bqy).a();
    rmw localrmw = this.jdField_a_of_type_Aytc.a();
    int i;
    if ((localObject == null) && (localrmw != null))
    {
      i = 1;
      if (this.isVip != 1) {
        break label156;
      }
    }
    label156:
    for (localObject = "1";; localObject = "2")
    {
      rar.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.bqy).a(localrmw);
      if ((localrmw != null) && (localrmw.a.type == 1)) {
        dov.com.qq.im.capture.view.MusicProviderView.dwS = true;
      }
      this.jdField_b_of_type_Aygz.changeState(0);
      this.jdField_b_of_type_Aygz.a(Message.obtain(null, 18, i, 0));
      return;
      if ((localObject != null) && (localrmw != null) && (!((rmw)localObject).equals(localrmw)))
      {
        i = 2;
        break;
      }
      if ((localObject != null) && (localrmw == null))
      {
        i = 3;
        break;
      }
      i = 4;
      break;
    }
  }
  
  private void eT(List<rmw> paramList)
  {
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (((rmw)paramList.next()).a.type == 1) {
        paramList.remove();
      }
    }
  }
  
  private void setVisibility(int paramInt)
  {
    if (this.mRootView != null) {
      this.mRootView.setVisibility(paramInt);
    }
  }
  
  private void showEmptyView()
  {
    this.mEmptyView.setVisibility(0);
    this.oS.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
    this.mLoadingView.setVisibility(8);
  }
  
  private void showLoadingView()
  {
    this.mLoadingView.setVisibility(0);
    this.oS.setVisibility(8);
    this.mEmptyView.setVisibility(8);
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setVisibility(8);
  }
  
  private void xf(int paramInt)
  {
    rmw localrmw = a(paramInt).a();
    if (localrmw == null)
    {
      this.qF.setText(acfp.m(2131705596));
      this.qF.setVisibility(8);
      this.g.setVisibility(0);
      this.g.setChecked(false);
      return;
    }
    this.qF.setText(localrmw.a.name);
    this.qF.setVisibility(0);
    this.g.setChecked(true);
  }
  
  public rmw a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_Aygz.tm()))
    {
      ram.e("Q.qqstory.publish.edit.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Aygz.tm()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a(int paramInt, @NonNull ayqb paramayqb)
  {
    ram.b("Q.qqstory.publish.edit.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    rmw localrmw = a(paramInt).a();
    if (localrmw == null)
    {
      ram.b("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    ram.b("Q.qqstory.publish.edit.EditVideoTag", "fragmentIndex=%s has tag, tag=%s", Integer.valueOf(paramInt), localrmw.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localrmw.a.id);
    localTagInfoBase.tag_type.set(localrmw.a.type);
    localTagInfoBase.tag_name.set(localrmw.a.name);
    localTagInfoBase.tag_desc.set(localrmw.a.desc);
    paramayqb.g.tagInfoBytes = localTagInfoBase.toByteArray();
  }
  
  public rmw b()
  {
    if ((this.bqy < 0) || (this.bqy >= this.jdField_b_of_type_Aygz.tm()))
    {
      ram.e("Q.qqstory.publish.edit.EditVideoTag", "getCurrentVideoTag videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Aygz.tm()), Integer.valueOf(this.bqy) });
      return null;
    }
    return a(this.bqy).a();
  }
  
  public void b(int paramInt, @Nonnull List<rmw> paramList, boolean paramBoolean)
  {
    Object localObject = this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
    if (paramInt == 0) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((QQStoryPullToRefreshListView)localObject).pn(paramBoolean);
      if (paramInt != 0) {
        break label104;
      }
      if (!paramList.isEmpty()) {
        break;
      }
      showEmptyView();
      return;
    }
    btw();
    rmw localrmw = this.jdField_a_of_type_Aytc.a();
    localObject = localrmw;
    if (!paramList.contains(localrmw)) {
      localObject = null;
    }
    a((rmw)localObject, false);
    this.jdField_a_of_type_Aytc.a((rmw)localObject);
    this.jdField_a_of_type_Aytc.setTags(paramList);
    this.jdField_a_of_type_Aytc.notifyDataSetChanged();
    return;
    label104:
    if (paramList.isEmpty())
    {
      btv();
      a(null, true);
      return;
    }
    btw();
  }
  
  public void c(int paramInt, @Nonnull List<rmw> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    rmw localrmw;
    if (paramInt == 0)
    {
      if (paramList.isEmpty())
      {
        showEmptyView();
        return;
      }
      btw();
      localrmw = this.jdField_a_of_type_Aytc.a();
      if (paramList.contains(localrmw)) {
        break label102;
      }
    }
    for (;;)
    {
      a((rmw)localObject, false);
      this.jdField_a_of_type_Aytc.a((rmw)localObject);
      this.jdField_a_of_type_Aytc.setTags(paramList);
      this.jdField_a_of_type_Aytc.notifyDataSetChanged();
      return;
      if (paramList.isEmpty())
      {
        btv();
        a(null, true);
        return;
      }
      btw();
      return;
      label102:
      localObject = localrmw;
    }
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    ram.d("Q.qqstory.publish.edit.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      setVisibility(8);
      return;
    case 34: 
      bsk();
      paramObject = a(this.bqy);
      ayic.a locala = a();
      if ((paramObject.ck() != null) && (!paramObject.ck().isEmpty()))
      {
        btw();
        if (!paramObject.a(locala)) {
          if (paramObject.a() != null) {
            this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(paramObject.ck().indexOf(paramObject.a()));
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_Aytc.a(paramObject.a());
          this.jdField_a_of_type_Aytc.setTags(paramObject.ck());
          this.jdField_a_of_type_Aytc.notifyDataSetChanged();
          a(paramObject.a(), false);
          setVisibility(0);
          return;
          this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.smoothScrollToPosition(0);
          continue;
          paramObject.b(locala);
        }
      }
      if ((this.oE != null) && (!this.oE.isEmpty()))
      {
        paramObject.fb(this.oE);
        btw();
      }
      for (;;)
      {
        paramObject.b(locala);
        break;
        showLoadingView();
      }
    }
    xf(this.bqy);
    setVisibility(8);
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.e(paramMessage);
      this.bqy = this.jdField_b_of_type_Aygz.tj();
      xf(this.bqy);
    }
  }
  
  public boolean onBackPressed()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mRootView != null)
    {
      bool1 = bool2;
      if (this.mRootView.getVisibility() == 0)
      {
        this.jdField_a_of_type_Aytc.a(null);
        this.jdField_b_of_type_Aygz.changeState(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Aytc.a(null);
      this.jdField_b_of_type_Aygz.changeState(0);
      continue;
      Object localObject = a(ayhj.class);
      if (localObject != null)
      {
        localObject = (ayhj)localObject;
        if ((!this.dzn) && (((ayhj)localObject).RT() != 10000) && (this.jdField_a_of_type_Aytc.a() != null))
        {
          this.dzn = true;
          aqha.a(getContext(), 230).setMessage(acfp.m(2131705662)).setPositiveButton(acfp.m(2131705630), new ayif(this)).show();
        }
        else
        {
          btx();
        }
      }
      else
      {
        btx();
        continue;
        showLoadingView();
        localObject = a();
        a(this.bqy).b((ayic.a)localObject);
        continue;
        this.jdField_a_of_type_Aytc.a(null);
        this.jdField_a_of_type_Aytc.notifyDataSetChanged();
        a(null, false);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.n = ((ViewStub)y(2131362238));
    this.g = ((PressDarkImageButton)y(2131362222));
    this.qF = ((TextView)y(2131379233));
    String str1 = this.jdField_b_of_type_Aygz.a.getStringExtra("video_tag_info");
    if (str1 != null) {}
    try
    {
      if ("web_medal".equals(new JSONObject(str1).optString("src_type"))) {}
      for (this.jdField_a_of_type_Ayic$b = null;; this.jdField_a_of_type_Ayic$b = ((ayic.b)JsonORM.parseFrom(new JSONObject(str1), ayic.b.class)))
      {
        xf(this.bqy);
        a(ayig.class, this);
        this.isVip = ((Integer)((psr)psx.a(10)).c("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
        if (this.isVip != 1) {
          break;
        }
        str1 = "1";
        rar.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.oE = aysy.a(this.mEntityManager);
        eT(this.oE);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.publish.edit.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
        continue;
        String str2 = "2";
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a(this.bqy).ck();
    if ((paramInt >= 0) && (paramInt < paramAdapterView.size()))
    {
      paramAdapterView = (rmw)paramAdapterView.get(paramInt);
      this.jdField_a_of_type_Aytc.a(paramAdapterView);
      this.jdField_a_of_type_Aytc.notifyDataSetChanged();
      a(paramAdapterView, false);
      if (this.isVip != 1) {
        break label90;
      }
    }
    label90:
    for (paramAdapterView = "1";; paramAdapterView = "2")
    {
      rar.a("video_edit", "clk_tag", 0, 0, new String[] { paramAdapterView });
      return;
    }
  }
  
  public void xe(int paramInt)
  {
    aysy localaysy = (aysy)this.aY.get(paramInt);
    if (localaysy == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localaysy.ck().remove(localaysy.a());
    localaysy.a(null);
    xf(this.bqy);
  }
  
  public static class a
  {
    public long BP;
    public boolean aHk;
    public int musicType;
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.musicType != paramObject.musicType) {
          return false;
        }
      } while (this.BP == paramObject.BP);
      return false;
    }
    
    public int hashCode()
    {
      return this.musicType * 31 + (int)(this.BP ^ this.BP >>> 32);
    }
    
    public String toString()
    {
      return "EditBehavior{hasMusic=" + this.aHk + ", musicType=" + this.musicType + ", musicId=" + this.BP + '}';
    }
  }
  
  public static class b
  {
    @JsonORM.a(key="tag_desc")
    public String desc;
    @JsonORM.a(key="tag_id")
    public long id;
    @JsonORM.a(key="join_count")
    public int joinCount;
    @JsonORM.a(key="tag_name")
    public String name;
    @JsonORM.a(key="tag_type")
    public int type;
    @JsonORM.a(key="wording")
    public String wording;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayic
 * JD-Core Version:    0.7.0.1
 */