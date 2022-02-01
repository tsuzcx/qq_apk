import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XFrameLayout;
import com.tencent.widget.XListView;

public abstract class awuo
  extends ReportFragment
{
  public awul a;
  public awuo.b a;
  public awux a;
  FrameLayout albumListRoot;
  AlbumListBaseData mAlbumListData;
  public XListView mListView;
  XFrameLayout xListLayout;
  
  @TargetApi(14)
  private void initUI(View paramView)
  {
    this.xListLayout = ((XFrameLayout)paramView.findViewById(2131370561));
    this.xListLayout.setCornerRadiusAndMode(Utils.dp2px(10.0D), 5);
    this.mListView = ((XListView)paramView.findViewById(2131362591));
    this.mListView.setWrapByScroll(true);
    this.mListView.setAdapter(this.jdField_a_of_type_Awul);
    this.mListView.setOnItemClickListener(new awuo.a(null));
    this.mListView.setOverScrollMode(2);
    this.mListView.setDivider(null);
    this.mListView.setVerticalScrollBarEnabled(false);
    this.albumListRoot = ((FrameLayout)paramView.findViewById(2131362622));
    this.albumListRoot.setOnClickListener(new awup(this));
    paramView.findViewById(2131362621).setVisibility(8);
    int i = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_index", 0);
    int j = getActivity().getIntent().getIntExtra("PhotoConst.photo_selection_y", 0);
    Looper.myQueue().addIdleHandler(new awuq(this, i, j));
    this.jdField_a_of_type_Awux.postInitUI();
  }
  
  protected abstract awux a();
  
  public void a(awuo.b paramb)
  {
    this.jdField_a_of_type_Awuo$b = paramb;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public Animator onCreateAnimator(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    return null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131561211, paramViewGroup, false);
    this.jdField_a_of_type_Awux = a();
    this.mAlbumListData = this.jdField_a_of_type_Awux.mAlbumListData;
    paramViewGroup = getActivity().getIntent();
    this.jdField_a_of_type_Awux.initData(paramViewGroup);
    initUI(paramLayoutInflater);
    FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_Awux != null) {
      this.jdField_a_of_type_Awux.close();
    }
  }
  
  class a
    implements AdapterView.c
  {
    private a() {}
    
    public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      paramAdapterView = awuo.this.jdField_a_of_type_Awul.getItem(paramInt);
      paramView = awuo.this.getActivity().getIntent();
      if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name))) {
        QQToast.a(awuo.this.getActivity(), 2131690269, 0).show();
      }
      boolean bool;
      do
      {
        return;
        bool = awuo.this.jdField_a_of_type_Awux.onItemClick(paramAdapterView, paramInt, paramView);
      } while (awuo.this.jdField_a_of_type_Awuo$b == null);
      awuo.this.jdField_a_of_type_Awuo$b.onAlbumListChoose(paramAdapterView, paramInt, bool);
    }
  }
  
  public static abstract interface b
  {
    public abstract void eGx();
    
    public abstract void onAlbumListChoose(QQAlbumInfo paramQQAlbumInfo, int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awuo
 * JD-Core Version:    0.7.0.1
 */