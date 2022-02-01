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
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.biz.qqstory.utils.JsonORM.a;
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
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class reh
  extends rdb
  implements View.OnClickListener, AdapterView.c, rek, rmu
{
  private rmv a;
  private SparseArray<rmr> aY = new SparseArray();
  private QQStoryPullToRefreshListView jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView;
  private reh.b jdField_b_of_type_Reh$b;
  private int bqy;
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
  
  public reh(@NonNull rdc paramrdc)
  {
    super(paramrdc);
  }
  
  private reh.a a()
  {
    reh.a locala = new reh.a();
    rbl localrbl = (rbl)a(rbl.class);
    if (localrbl != null) {
      localrbl.a(locala);
    }
    return locala;
  }
  
  @Nonnull
  private rmr a(int paramInt)
  {
    Object localObject2 = (rmr)this.aY.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new rmr(this, this.mEntityManager);
      ((rmr)localObject1).reset();
      if (this.jdField_b_of_type_Reh$b != null)
      {
        localObject2 = new rmw(new rmw.a(this.jdField_b_of_type_Reh$b.id, this.jdField_b_of_type_Reh$b.name, this.jdField_b_of_type_Reh$b.desc, this.jdField_b_of_type_Reh$b.type), this.jdField_b_of_type_Reh$b.joinCount, this.jdField_b_of_type_Reh$b.wording);
        ((rmr)localObject1).ck().add(localObject2);
        ((rmr)localObject1).a((rmw)localObject2);
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
      this.a = new rmv(getContext());
      btl();
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setAdapter(this.a);
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnItemClickListener(this);
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setPullToRefreshListener(new rei(this));
      this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.setOnScrollListener(new rej(this));
      this.yt.setOnClickListener(this);
      this.yu.setOnClickListener(this);
    }
  }
  
  private void btl()
  {
    this.jdField_b_of_type_ComTencentBizQqstoryViewWidgetQQStoryPullToRefreshListView.e.setHeaderBgColor(0);
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
    rmw localrmw = this.a.a();
    int i;
    if ((localObject == null) && (localrmw != null))
    {
      i = 1;
      if (this.isVip != 1) {
        break label121;
      }
    }
    label121:
    for (localObject = "1";; localObject = "2")
    {
      rar.a("video_edit", "suc_tag", 0, i, new String[] { localObject });
      a(this.bqy).a(localrmw);
      this.jdField_b_of_type_Rdc.changeState(0);
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
      this.qF.setText(acfp.m(2131705493));
      return;
    }
    this.qF.setText(localrmw.a.name);
  }
  
  public rmw a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_b_of_type_Rdc.tm()))
    {
      ram.e("Q.qqstory.detail.EditVideoTag", "videoIndex is illegal, videoCount:%s, videoIndex=%s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Rdc.tm()), Integer.valueOf(paramInt) });
      return null;
    }
    return a(paramInt).a();
  }
  
  public void a(int paramInt, @NonNull rkm paramrkm)
  {
    ram.b("Q.qqstory.detail.EditVideoTag", "editVideoPrePublish, fragmentIndex=%s", Integer.valueOf(paramInt));
    rmw localrmw = a(paramInt).a();
    if (localrmw == null)
    {
      ram.b("Q.qqstory.detail.EditVideoTag", "fragmentIndex=%s has no tag.", Integer.valueOf(paramInt));
      return;
    }
    ram.b("Q.qqstory.detail.EditVideoTag", "fragmentIndex=%s has tag, tag=", Integer.valueOf(paramInt), localrmw.toString());
    qqstory_struct.TagInfoBase localTagInfoBase = new qqstory_struct.TagInfoBase();
    localTagInfoBase.tag_id.set(localrmw.a.id);
    localTagInfoBase.tag_type.set(localrmw.a.type);
    localTagInfoBase.tag_name.set(localrmw.a.name);
    localTagInfoBase.tag_desc.set(localrmw.a.desc);
    paramrkm.g.tagInfoBytes = localTagInfoBase.toByteArray();
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
    rmw localrmw = this.a.a();
    localObject = localrmw;
    if (!paramList.contains(localrmw)) {
      localObject = null;
    }
    a((rmw)localObject, false);
    this.a.a((rmw)localObject);
    this.a.setTags(paramList);
    this.a.notifyDataSetChanged();
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
      localrmw = this.a.a();
      if (paramList.contains(localrmw)) {
        break label102;
      }
    }
    for (;;)
    {
      a((rmw)localObject, false);
      this.a.a((rmw)localObject);
      this.a.setTags(paramList);
      this.a.notifyDataSetChanged();
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
    ram.d("Q.qqstory.detail.EditVideoTag", "editVideoStateChanged [" + paramInt1 + " ---> " + paramInt2 + "]");
    switch (paramInt2)
    {
    default: 
      setVisibility(8);
      return;
    case 28: 
      bsk();
      paramObject = a(this.bqy);
      reh.a locala = a();
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
          this.a.a(paramObject.a());
          this.a.setTags(paramObject.ck());
          this.a.notifyDataSetChanged();
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
      this.bqy = this.jdField_b_of_type_Rdc.tj();
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
        this.a.a(null);
        this.jdField_b_of_type_Rdc.changeState(0);
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
      this.a.a(null);
      this.jdField_b_of_type_Rdc.changeState(0);
      continue;
      btx();
      continue;
      showLoadingView();
      reh.a locala = a();
      a(this.bqy).b(locala);
      continue;
      this.a.a(null);
      this.a.notifyDataSetChanged();
      a(null, false);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.n = ((ViewStub)y(2131362238));
    this.qF = ((TextView)y(2131379178));
    String str1 = this.jdField_b_of_type_Rdc.a.getStringExtra("video_tag_info");
    if (str1 != null) {}
    try
    {
      this.jdField_b_of_type_Reh$b = ((reh.b)JsonORM.parseFrom(new JSONObject(str1), reh.b.class));
      xf(this.bqy);
      a(rek.class, this);
      this.isVip = ((Integer)((psr)psx.a(10)).c("qqstory_i_am_vip", Integer.valueOf(0))).intValue();
      if (this.isVip == 1)
      {
        str1 = "1";
        rar.a("video_edit", "exp_tag", 0, 0, new String[] { str1 });
        this.oE = rmr.a(this.mEntityManager);
        eT(this.oE);
        return;
      }
    }
    catch (JsonORM.JsonParseException localJsonParseException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.detail.EditVideoTag", "JsonORM.parseFrom JsonParseException", localJsonParseException);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ram.w("Q.qqstory.detail.EditVideoTag", "JsonORM.parseFrom JSONException", localJSONException);
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
      this.a.a(paramAdapterView);
      this.a.notifyDataSetChanged();
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
    rmr localrmr = (rmr)this.aY.get(paramInt);
    if (localrmr == null) {
      throw new IllegalStateException("get presenter with videoIndex=" + paramInt + " null? why?");
    }
    localrmr.ck().remove(localrmr.a());
    localrmr.a(null);
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
    @JsonORM.a(key="music_title")
    public String azO;
    @JsonORM.a(key="music_download_url")
    public String azP;
    @JsonORM.a(key="tag_desc")
    public String desc;
    @JsonORM.a(key="tag_id")
    public long id;
    @JsonORM.a(key="join_count")
    public int joinCount;
    @JsonORM.a(key="music_id")
    public String musicId;
    @JsonORM.a(key="music_type")
    public int musicType;
    @JsonORM.a(key="tag_name")
    public String name;
    @JsonORM.a(key="tag_type")
    public int type;
    @JsonORM.a(key="wording")
    public String wording;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     reh
 * JD-Core Version:    0.7.0.1
 */