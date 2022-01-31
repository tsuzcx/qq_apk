package cooperation.qqfav.widget;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.util.VersionUtils;
import com.tencent.widget.FadeIconImageView;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavUtil;
import flf;
import flg;
import flh;

public class LocationDetailActivity
  extends PoiMapActivity
{
  public static final int j = 13321;
  public static final int k = 13322;
  public static final String s = "forNewFavorite";
  public long a;
  private FadeIconImageView a;
  public ImageView f = null;
  public TextView g = null;
  private boolean q = false;
  public String t;
  public String u;
  public String v;
  public String w = null;
  
  public LocationDetailActivity()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = null;
  }
  
  private void s()
  {
    if (this.g == null) {
      return;
    }
    if (TextUtils.isEmpty(this.w))
    {
      this.g.setVisibility(8);
      return;
    }
    this.g.setVisibility(0);
    if (VersionUtils.e()) {
      this.g.setAlpha(0.9F);
    }
    this.g.setText(new QQText(this.w, 3, 22));
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = b(this);
    Intent localIntent = new Intent(c(this));
    localIntent.putExtras((Intent)localObject);
    localIntent.putExtra("modify", paramBoolean);
    localIntent.putExtra("favId", this.jdField_a_of_type_Long);
    localIntent.putExtra("note", this.w);
    localIntent.setClassName("com.qqfav", "com.qqfav.activity.AddLocationFavActivity");
    localObject = localIntent.getStringExtra("pluginsdk_selfuin");
    if (paramBoolean) {}
    for (int i = 13322;; i = 13321)
    {
      QfavHelper.a(this, (String)localObject, localIntent, i);
      return;
    }
  }
  
  protected void m()
  {
    Object localObject = super.getIntent().getExtras();
    this.v = ((Bundle)localObject).getString("loc");
    this.t = ((Bundle)localObject).getString("lat");
    this.u = ((Bundle)localObject).getString("lon");
    this.jdField_a_of_type_Long = ((Bundle)localObject).getLong("favId");
    TextView localTextView = (TextView)findViewById(2131296901);
    localTextView.setText(2131362699);
    localTextView.setOnClickListener(new flf(this));
    ((TextView)super.findViewById(2131296895)).setText(2131362699);
    localTextView = (TextView)super.findViewById(2131296905);
    if (!((Bundle)localObject).getBoolean("forNewFavorite", false))
    {
      localObject = new flg(this, this, new LocationDetailActivity.LocationActions(this), 33, 7, null, false);
      localTextView.setVisibility(8);
      this.f = ((ImageView)super.findViewById(2131296906));
      this.f.setVisibility(0);
      this.f.setImageResource(2130838044);
      this.f.setContentDescription(super.getString(2131363193));
      this.f.setOnClickListener((View.OnClickListener)localObject);
      this.jdField_a_of_type_ComTencentWidgetFadeIconImageView = ((FadeIconImageView)findViewById(2131296907));
      if (!QfavUtil.a()) {
        if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
        {
          this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(0);
          this.q = true;
        }
      }
    }
    for (;;)
    {
      localTextView.setTag(localTextView.getText());
      return;
      if (this.jdField_a_of_type_ComTencentWidgetFadeIconImageView != null)
      {
        this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
        continue;
        localTextView.setText(2131363507);
        localTextView.setOnClickListener(new flh(this));
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if ((paramInt1 != 103) || (paramIntent == null)) {
        break label208;
      }
      Intent localIntent = super.a();
      localIntent.setClass(this, ChatActivity.class);
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("forward_latitude", localIntent.getStringExtra("latitude")).putExtra("forward_longitude", localIntent.getStringExtra("longitude")).putExtra("forward_location", localIntent.getStringExtra("description")).putExtra("forward_location_string", localIntent.getStringExtra("description")).putExtra("forward_thumb", AppConstants.aV + this.t + "_" + this.u + ".png").putExtra("isFromFavorites", true).putExtra("title", this.o).putExtra("summary", this.p);
      super.startActivity(localIntent);
      super.finish();
    }
    for (;;)
    {
      if ((this.f != null) && (13322 != paramInt1)) {
        this.f.setOnClickListener(null);
      }
      return;
      label208:
      if (13321 == paramInt1)
      {
        super.finish();
      }
      else if ((13322 == paramInt1) && (paramIntent != null))
      {
        this.w = paramIntent.getStringExtra("note");
        s();
      }
    }
  }
  
  public void onBackPressed()
  {
    super.setResult(0, new Intent());
    if (this.f != null) {
      this.f.setOnClickListener(null);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView.getId();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = ((TextView)super.findViewById(2131297922));
    this.w = super.getIntent().getStringExtra("note");
    this.l = true;
    if (this.h != null) {
      this.h.setVisibility(8);
    }
    s();
  }
  
  public void onStart()
  {
    super.overridePendingTransition(0, 0);
    super.onStart();
  }
  
  public void setContentView(int paramInt)
  {
    if (super.getIntent().getBooleanExtra("forNewFavorite", false))
    {
      super.setContentView(paramInt);
      return;
    }
    super.setContentView(2130903386);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */