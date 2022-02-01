import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogic.IalbumListAdapterCallBack;
import com.tencent.mobileqq.activity.photo.album.AlbumListLogicBase;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class ztp
  extends AlbumListLogicBase<AlbumListFragment, zuc>
  implements AlbumListLogic.IalbumListAdapterCallBack
{
  protected zto a;
  
  public ztp(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
    this.mAlbumListAdapterCallBack = this;
    this.mAlbumListData = new zto();
    this.a = ((zto)this.mAlbumListData);
  }
  
  protected ztr a()
  {
    return (ztr)super.getAlbumListAdapter();
  }
  
  protected zuc a()
  {
    return new ztq(this);
  }
  
  public String adapterGenerateSelection()
  {
    return super.adapterGenerateSelection();
  }
  
  public AlbumListAdapter generateAlbumListAdapter()
  {
    return new ztr((AlbumListFragment)this.mFragment);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = a();
    Object localObject = paramViewGroup.getItem(paramInt);
    TextView localTextView = (TextView)paramView;
    if (((QQAlbumInfo)localObject)._id.equals("qzone_album"))
    {
      localObject = paramViewGroup.mResources.getDrawable(2130848527);
      ((Drawable)localObject).setBounds(0, 0, paramViewGroup.mCoverWidth, paramViewGroup.mCoverHeight);
      localTextView.setCompoundDrawables((Drawable)localObject, null, null, null);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramView.setBackgroundColor(-16777216);
      localTextView.setTextColor(-9211021);
    }
    return paramView;
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.a.bti = paramIntent.getBooleanExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", false);
    String str2 = paramIntent.getStringExtra("peak.myUin");
    String str1 = str2;
    if (str2 == null) {
      str1 = axol.getAppInterface().getCurrentAccountUin();
    }
    if (str1 != null) {
      this.mPhotoCommonData.myUin = str1;
    }
    if (this.mPhotoCommonData.myUin == null) {
      throw new RuntimeException("must set MY_UIN");
    }
    this.mPhotoCommonData.isShowQzoneAlbum = paramIntent.getBooleanExtra("PhotoConst.IS_SHOW_QZONE_ALBUM", false);
    a().gC(((zuc)this.mOtherCommonData).Ly);
    this.mPhotoCommonData.mIsDisableTroopAlbum = paramIntent.getBooleanExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.mPhotoCommonData.mIsDisableTroopAlbum);
    if ((this.mPhotoCommonData.isShowQzoneAlbum) && (!((zuc)this.mOtherCommonData).btu))
    {
      this.a.c = new ztp.a();
      paramIntent = new NewIntent(BaseApplicationImpl.getApplication(), anem.class);
      paramIntent.putExtra("selfuin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
      BaseApplicationImpl.getApplication().getRuntime().registObserver(this.a.c);
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramIntent);
    }
  }
  
  public boolean needUpdateAlbum(boolean paramBoolean, QQAlbumInfo paramQQAlbumInfo)
  {
    return (!paramQQAlbumInfo._id.equals("qzone_album")) && (paramBoolean);
  }
  
  public boolean onItemClick(QQAlbumInfo paramQQAlbumInfo, int paramInt, Intent paramIntent)
  {
    Object localObject;
    if (paramQQAlbumInfo._id.equals("qzone_album"))
    {
      localObject = paramIntent.getExtras();
      ((Bundle)localObject).putInt("key_personal_album_enter_model", 1);
      ((Bundle)localObject).putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      ((Bundle)localObject).putSerializable("PhotoConst.PHOTO_INFOS", paramIntent.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      ((Bundle)localObject).putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      ((Bundle)localObject).putStringArrayList("PhotoConst.PHOTO_PATHS", paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      avpw.d locald = avpw.d.a();
      locald.cMP = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      ((Bundle)localObject).putString("keyAction", "actionSelectPicture");
      ((Bundle)localObject).putBoolean("key_need_change_to_jpg", true);
      avpw.a(((AlbumListFragment)this.mFragment).getActivity(), locald, (Bundle)localObject, 100016);
      return checkAlbumChange(paramIntent, paramQQAlbumInfo);
    }
    if (paramQQAlbumInfo._id.equals("$CustomAlbumId"))
    {
      localObject = rma.a().ci();
      if (((List)localObject).size() > 0) {
        paramIntent.putExtra("ALBUM_NAME", ((LocalMediaInfo)((List)localObject).get(0)).mAlbumName);
      }
      paramIntent.putExtra("ALBUM_ID", "$CustomAlbumId");
      paramIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", 5);
      paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", false);
      paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 10);
      paramIntent.putExtra("report_first_exposure", true);
      paramIntent.putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
      paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", true);
      paramIntent.putExtra("PhotoConst.IS_FROM_EDIT", false);
      return checkAlbumChange(paramIntent, paramQQAlbumInfo);
    }
    paramIntent.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramIntent.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    if ("$VideoAlbumId".equals(paramQQAlbumInfo._id)) {
      anot.a(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
    }
    return super.onItemClick(paramQQAlbumInfo, paramInt, paramIntent);
  }
  
  public void postInitUI() {}
  
  public List<LocalMediaInfo> queryRecentImageList(Context paramContext, int paramInt1, int paramInt2, MediaFileFilter paramMediaFileFilter, int paramInt3, boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    return super.queryRecentImageList(paramContext, paramInt1, paramInt2, paramMediaFileFilter, paramInt3, paramBoolean, paramArrayList);
  }
  
  class a
    extends akln
  {
    a() {}
    
    protected void E(boolean paramBoolean, Bundle paramBundle)
    {
      paramBundle = paramBundle.getSerializable("data");
      if ((paramBoolean) && ((paramBundle instanceof get_albumlist_num_rsp)))
      {
        long l = ((get_albumlist_num_rsp)paramBundle).album_num;
        ((zuc)ztp.this.mOtherCommonData).Ly = l;
        paramBundle = ztp.this.a();
        if (paramBundle != null)
        {
          paramBundle.gC(((zuc)ztp.this.mOtherCommonData).Ly);
          paramBundle.postData();
        }
      }
      ((zuc)ztp.this.mOtherCommonData).btu = false;
      BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(ztp.this.a.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztp
 * JD-Core Version:    0.7.0.1
 */