package cooperation.qqfav.widget;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.util.VersionUtils;
import ibl;
import ibm;
import ibn;
import ibo;

public class LocationDetailActivity
  extends PoiMapActivity
{
  public static final int m = 13321;
  public static final String r = "forNewFavorite";
  public ImageView f = null;
  public TextView h = null;
  public String s;
  public String t;
  public String u;
  public String v = null;
  
  private void t()
  {
    if (this.h == null) {
      return;
    }
    if (this.a)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968646);
      localAnimation.setAnimationListener(new ibl(this));
      this.h.startAnimation(localAnimation);
      return;
    }
    if (TextUtils.isEmpty(this.v))
    {
      this.h.setVisibility(8);
      return;
    }
    this.h.setVisibility(0);
    if (VersionUtils.e()) {
      this.h.setAlpha(0.9F);
    }
    this.h.setText(new QQText(this.v, 3, 22));
  }
  
  protected void n()
  {
    Bundle localBundle = getIntent().getExtras();
    this.u = localBundle.getString("loc");
    this.s = localBundle.getString("lat");
    this.t = localBundle.getString("lon");
    TextView localTextView1 = (TextView)findViewById(2131231456);
    localTextView1.setText(2131560774);
    localTextView1.setOnClickListener(new ibm(this));
    ((TextView)findViewById(2131231376)).setText(2131560811);
    TextView localTextView2 = (TextView)findViewById(2131231380);
    if (!localBundle.getBoolean("forNewFavorite", false))
    {
      FavoriteActionSheet localFavoriteActionSheet = new FavoriteActionSheet(this, new ibo(this), 1, 7, null);
      localTextView1.setText(localBundle.getString("leftViewText"));
      localTextView2.setVisibility(8);
      this.f = ((ImageView)findViewById(2131231461));
      this.f.setVisibility(0);
      this.f.setImageResource(2130837835);
      this.f.setContentDescription(getString(2131562926));
      this.f.setOnClickListener(localFavoriteActionSheet);
    }
    for (;;)
    {
      localTextView2.setTag(localTextView2.getText());
      return;
      localTextView1.setText(2131560958);
      localTextView2.setText(2131562463);
      localTextView2.setOnClickListener(new ibn(this));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if ((paramInt1 != 103) || (paramIntent == null)) {
        break label190;
      }
      Intent localIntent = a();
      localIntent.setClass(this, ChatActivity.class);
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("forward_latitude", localIntent.getStringExtra("latitude")).putExtra("forward_longitude", localIntent.getStringExtra("longitude")).putExtra("forward_location", localIntent.getStringExtra("description")).putExtra("forward_location_string", localIntent.getStringExtra("description")).putExtra("forward_thumb", AppConstants.aQ + this.s + "_" + this.t + ".png").putExtra("isFromFavorites", true).putExtra("title", this.o).putExtra("summary", this.p);
      startActivity(localIntent);
      finish();
    }
    for (;;)
    {
      if (this.f != null) {
        this.f.setOnClickListener(null);
      }
      return;
      label190:
      if (13321 == paramInt1) {
        finish();
      }
    }
  }
  
  public void onBackPressed()
  {
    setResult(0, new Intent());
    if (this.f != null) {
      this.f.setOnClickListener(null);
    }
    super.finish();
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    default: 
      return;
    }
    t();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = ((TextView)findViewById(2131232682));
    this.v = getIntent().getStringExtra("note");
    this.l = true;
    if (this.j != null) {
      this.j.setVisibility(8);
    }
    t();
  }
  
  public void onStart()
  {
    super.overridePendingTransition(0, 0);
    super.onStart();
  }
  
  public void setContentView(int paramInt)
  {
    if (getIntent().getBooleanExtra("forNewFavorite", false))
    {
      super.setContentView(paramInt);
      return;
    }
    super.setContentView(2130903468);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     cooperation.qqfav.widget.LocationDetailActivity
 * JD-Core Version:    0.7.0.1
 */