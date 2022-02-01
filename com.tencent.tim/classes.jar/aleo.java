import QQService.EVIPSPEC;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.pb.profilecard.VaProfileGate.CommTaskInfo;
import com.tencent.pb.profilecard.VipMusicBox.GetProfileMusicBoxInfoRsp;
import com.tencent.pb.profilecard.VipMusicBox.ProfileMusicInfo;
import com.tencent.pb.profilecard.VipMusicBox.ProfileSingerInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AlphaClickableImageView;

public class aleo
  implements alep.a, View.OnClickListener
{
  private View FS;
  private AlphaClickableImageView a;
  private alep b;
  private boolean bFk = true;
  private String bWf = "";
  private String bWg = "";
  private boolean cwv;
  private boolean cww;
  private int deT;
  private SongInfo mCurrentSongInfo = new SongInfo();
  private boolean mIsEmpty;
  private boolean mIsPlaying;
  
  public aleo(boolean paramBoolean)
  {
    this.cww = paramBoolean;
  }
  
  public static void a(VaProfileGate.CommTaskInfo paramCommTaskInfo, Card paramCard)
  {
    int k = 1;
    int j = 1;
    VipMusicBox.GetProfileMusicBoxInfoRsp localGetProfileMusicBoxInfoRsp = new VipMusicBox.GetProfileMusicBoxInfoRsp();
    for (;;)
    {
      try
      {
        localGetProfileMusicBoxInfoRsp.mergeFrom(paramCommTaskInfo.bytes_task_data.get().toByteArray());
        paramCard.coverUrl = localGetProfileMusicBoxInfoRsp.music.pic.get();
        paramCommTaskInfo = new StringBuilder();
        i = 0;
        if (i < localGetProfileMusicBoxInfoRsp.music.singer_list.size())
        {
          if (i != 0) {
            paramCommTaskInfo.append("/");
          }
          paramCommTaskInfo.append(((VipMusicBox.ProfileSingerInfo)localGetProfileMusicBoxInfoRsp.music.singer_list.get(i)).singer_name.get());
          i += 1;
          continue;
        }
        paramCard.singer = paramCommTaskInfo.toString();
        paramCard.songId = localGetProfileMusicBoxInfoRsp.music.song_id.get();
        paramCard.songName = localGetProfileMusicBoxInfoRsp.music.song_name.get();
        paramCard.songDuration = localGetProfileMusicBoxInfoRsp.music.duration.get();
        if (QLog.isColorLevel()) {
          QLog.e("ProfileMusicBox", 2, "card songId :" + paramCard.songId + " " + paramCard.songName);
        }
        paramCommTaskInfo = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        if (paramCommTaskInfo == null) {
          break label336;
        }
        if (paramCommTaskInfo.getAccount().equalsIgnoreCase(paramCard.uin))
        {
          if (!atu()) {
            break label337;
          }
          i = j;
          if (TextUtils.isEmpty(paramCard.songId)) {
            i = 2;
          }
          anot.a(null, "dc00898", "", "", "qq_vip", "0X800A7D6", i, 0, "", "", "", "");
          return;
        }
        paramCommTaskInfo = paramCard.uin;
        if (atu())
        {
          i = k;
          anot.a(null, "dc00898", "", paramCommTaskInfo, "qq_vip", "0X800A7DC", i, 0, "", "", "", "");
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramCommTaskInfo)
      {
        paramCommTaskInfo.printStackTrace();
        return;
      }
      int i = 2;
      continue;
      label336:
      return;
      label337:
      i = 3;
    }
  }
  
  public static boolean atu()
  {
    return (VipUtils.ce((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime())) || (VipUtils.cd((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()));
  }
  
  public static void bO(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    paramString = aurr.addParameter(aery.a().bAL, "uin", paramString);
    localIntent.setFlags(268435456);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean c(alcn paramalcn)
  {
    int i;
    if (paramalcn.e.pa == 0) {
      if (paramalcn.d.switch_musicbox == 0)
      {
        i = 1;
        anot.a(null, "dc00898", "", "", "0X800A7DB", "qq_vip", i, 0, "", "", "", "");
        if (paramalcn.d.switch_musicbox != 0) {
          break label64;
        }
      }
    }
    label64:
    boolean bool1;
    boolean bool2;
    do
    {
      return true;
      i = 2;
      break;
      return false;
      bool1 = paramalcn.d.isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = paramalcn.d.isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
    } while ((paramalcn.d.switch_musicbox == 0) && (!TextUtils.isEmpty(paramalcn.d.songId)) && ((bool1) || (bool2)));
    return false;
  }
  
  public void ND(boolean paramBoolean)
  {
    this.mIsEmpty = paramBoolean;
    if (!this.cww)
    {
      TextView localTextView = (TextView)this.FS.findViewById(2131378565);
      if (paramBoolean)
      {
        localTextView.setVisibility(8);
        return;
      }
      localTextView.setVisibility(0);
      return;
    }
    if (paramBoolean)
    {
      this.FS.findViewById(2131366432).setVisibility(0);
      this.FS.findViewById(2131378723).setVisibility(8);
      this.FS.findViewById(2131372092).setVisibility(8);
      return;
    }
    this.FS.findViewById(2131366432).setVisibility(8);
    this.FS.findViewById(2131378723).setVisibility(0);
    this.FS.findViewById(2131372092).setVisibility(0);
  }
  
  public void Oc(String paramString)
  {
    int i = 1;
    if (this.bWg.equals(paramString)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = this.FS.getContext().getResources().getDrawable(2130845704);
    localURLDrawableOptions.mFailedDrawable = this.FS.getContext().getResources().getDrawable(2130845704);
    paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    paramString.setTag(new int[] { this.deT / 2 });
    paramString.setDecodeHandler(aqbn.z);
    paramString.startDownload();
    this.FS.findViewById(2131378723).setBackgroundDrawable(paramString);
    if (this.mIsPlaying) {}
    for (;;)
    {
      SL(i);
      return;
      i = 2;
    }
  }
  
  @SuppressLint({"NewApi"})
  public void SL(int paramInt)
  {
    if (this.cww)
    {
      if (paramInt == 1)
      {
        this.a.setImageResource(2130845705);
        this.a.setContentDescription("暂停音乐");
        return;
      }
      this.a.setImageResource(2130845706);
      this.a.setContentDescription("播放音乐");
      return;
    }
    TextView localTextView = (TextView)this.FS.findViewById(2131378565);
    localTextView.setCompoundDrawablePadding(aqnm.dpToPx(4.0F));
    if (paramInt == 1)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(2130851279, 0, 0, 0);
      return;
    }
    localTextView.setCompoundDrawablesWithIntrinsicBounds(2130851280, 0, 0, 0);
  }
  
  public void a(SongInfo paramSongInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ProfileMusicBox", 2, "update :" + paramSongInfo.title);
    }
    if (paramSongInfo.uin != Long.parseLong(this.bWf)) {
      return;
    }
    this.mCurrentSongInfo = paramSongInfo;
    this.mIsPlaying = paramBoolean;
    if (this.cww)
    {
      ((TextView)this.FS.findViewById(2131378564)).setText(paramSongInfo.title);
      ((TextView)this.FS.findViewById(2131378563)).setText(paramSongInfo.singer);
      Oc(paramSongInfo.coverUrl);
      return;
    }
    ((TextView)this.FS.findViewById(2131378565)).setText(paramSongInfo.title + "-" + paramSongInfo.singer);
    if (this.mIsPlaying) {}
    for (int i = 1;; i = 2)
    {
      SL(i);
      return;
    }
  }
  
  public View b(Context paramContext, String paramString)
  {
    this.bWf = paramString;
    this.FS = LayoutInflater.from(paramContext).inflate(2131562224, null);
    this.FS.setOnClickListener(this);
    if (this.cww)
    {
      this.FS.findViewById(2131369181).setOnClickListener(this);
      this.FS.findViewById(2131378723).setOnClickListener(this);
      this.a = ((AlphaClickableImageView)this.FS.findViewById(2131378723));
      this.FS.findViewById(2131378565).setVisibility(8);
    }
    for (;;)
    {
      SL(2);
      this.deT = wja.dp2px(35.0F, paramContext.getResources());
      if (this.b == null) {
        this.b = ListenTogetherManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a();
      }
      this.b.a(this);
      return this.FS;
      this.FS.findViewById(2131378565).setOnClickListener(this);
      this.FS.findViewById(2131369181).setVisibility(8);
    }
  }
  
  public void bN(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", aurr.addParameter(aery.a().bAK, "uin", paramString));
    paramContext.startActivity(localIntent);
    int i = 2;
    if (atu()) {
      if (!this.mIsEmpty) {}
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "qq_vip", "0X800A7D7", i, 0, "", "", "", "");
      return;
      i = 1;
      continue;
      i = 3;
    }
  }
  
  public void d(alcn paramalcn)
  {
    Object localObject = paramalcn.d;
    boolean bool1 = ((Card)localObject).isVipOpen(EVIPSPEC.E_SP_SUPERVIP);
    boolean bool2 = ((Card)localObject).isVipOpen(EVIPSPEC.E_SP_BIGCLUB);
    if ((bool1) || (bool2)) {}
    for (bool1 = true;; bool1 = false)
    {
      this.cwv = bool1;
      if (!TextUtils.isEmpty(((Card)localObject).songId)) {
        break;
      }
      ND(true);
      localObject = (TextView)this.FS.findViewById(2131379562);
      if (paramalcn.e.pa != 0)
      {
        this.bFk = false;
        ((TextView)localObject).setText(ProfileCardMoreInfoView.a(paramalcn) + ((TextView)localObject).getContext().getResources().getString(2131697327));
      }
      return;
    }
    ND(false);
    SongInfo localSongInfo = QQPlayerService.a();
    if ((localSongInfo != null) && (localSongInfo.uin == Long.parseLong(this.bWf)))
    {
      this.mCurrentSongInfo = localSongInfo;
      SL(QQPlayerService.getPlayState());
    }
    for (;;)
    {
      a(this.mCurrentSongInfo, alep.o(Long.parseLong(this.bWf)));
      break;
      this.mCurrentSongInfo.title = ((Card)localObject).songName;
      this.mCurrentSongInfo.coverUrl = ((Card)localObject).coverUrl;
      this.mCurrentSongInfo.singer = ((Card)localObject).singer;
      this.mCurrentSongInfo.album = ((Card)localObject).songId;
      this.mCurrentSongInfo.type = 10;
      this.mCurrentSongInfo.uin = Long.parseLong(this.bWf);
    }
  }
  
  public void dFt()
  {
    if ((this.mIsEmpty) && (!this.cww)) {
      this.FS.findViewById(2131378565).setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    dFt();
    if (this.mIsEmpty) {
      bN(paramView.getContext(), this.bWf);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131365089: 
      case 2131373647: 
        if (this.bFk) {
          bN(paramView.getContext(), this.bWf);
        } else {
          bO(paramView.getContext(), this.bWf);
        }
        break;
      case 2131369181: 
        bO(paramView.getContext(), this.bWf);
        break;
      case 2131378565: 
      case 2131378723: 
        if (this.bFk)
        {
          anot.a(null, "dc00898", "", "", "qq_vip", "0X800A7D8", 0, 0, "", "", "", "");
          if ((!this.cwv) && (this.bFk)) {
            bN(paramView.getContext(), this.bWf);
          }
        }
        else
        {
          String str = this.bWf;
          if (atu()) {}
          for (int i = 1;; i = 2)
          {
            anot.a(null, "dc00898", "", str, "qq_vip", "0X800A7DD", i, 0, "", "", "", "");
            break;
          }
        }
        if (alep.o(Long.parseLong(this.bWf)))
        {
          this.b.Zx();
          SL(2);
        }
        else
        {
          this.b.b(Long.parseLong(this.bWf), this.mCurrentSongInfo);
        }
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aleo
 * JD-Core Version:    0.7.0.1
 */