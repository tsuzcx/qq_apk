import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;

public class rka
  extends BaseAdapter
{
  protected static int bsA;
  protected static int bsB;
  protected static int bsz;
  protected GridView a;
  protected rkc d;
  protected Context mContext;
  protected boolean mIsTakePhoto;
  protected ArrayList<rkc> nD;
  protected ArrayList<rkc> nF;
  
  public rka(Context paramContext, GridView paramGridView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mContext = paramContext;
    this.a = paramGridView;
    this.mIsTakePhoto = paramBoolean1;
    paramContext = this.mContext.getResources();
    bsz = wja.dp2px(80.0F, paramContext);
    bsA = wja.dp2px(10.0F, paramContext);
    bsB = wja.dp2px(5.0F, paramContext);
    this.a.setColumnWidth(bsz);
    this.nF = new ArrayList();
    this.nF.add(rkc.e);
    if (!paramBoolean1) {
      this.nF.add(rkc.f);
    }
    if (paramBoolean2) {
      this.nF.add(rkc.g);
    }
  }
  
  public int a(rkc paramrkc)
  {
    if (this.nD != null) {
      return this.nD.indexOf(paramrkc);
    }
    return -1;
  }
  
  public rkc b()
  {
    return this.d;
  }
  
  public void bvh()
  {
    int j = 0;
    int i = j;
    if (this.nD != null)
    {
      i = j;
      if (this.nD.contains(rkc.g))
      {
        this.nD.remove(rkc.g);
        this.nF.remove(rkc.g);
        i = 1;
      }
    }
    if (i != 0) {
      notifyDataSetChanged();
    }
  }
  
  public void cr(ArrayList<rkc> paramArrayList)
  {
    this.nD = new ArrayList();
    if (paramArrayList != null) {
      this.nD.addAll(paramArrayList);
    }
    this.nD.addAll(0, this.nF);
    int i = getCount();
    this.a.setNumColumns(i);
    paramArrayList = (LinearLayout.LayoutParams)this.a.getLayoutParams();
    int j = bsz;
    paramArrayList.width = ((i - 1) * bsA + j * i + this.a.getPaddingLeft() + this.a.getPaddingRight());
    this.a.setLayoutParams(paramArrayList);
  }
  
  public void f(rkc paramrkc)
  {
    this.d = paramrkc;
  }
  
  public int getCount()
  {
    if (this.nD == null) {
      return 0;
    }
    return this.nD.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.nD != null) {
      return this.nD.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    rkc localrkc = (rkc)getItem(paramInt);
    Object localObject1;
    if (localrkc == null)
    {
      localObject1 = null;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.mContext);
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      localTextView.setTextSize(12.0F);
      localTextView.setLayoutParams(new AbsListView.LayoutParams(bsz, bsz));
      localTextView.setPadding(bsB, bsA, bsB, 0);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localObject1 = localTextView;
      label116:
      localTextView.setText(localrkc.title);
      if (localrkc.musicType != 0) {
        break label234;
      }
      localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847528, 0, 0);
      if (localrkc.equals(this.d)) {
        localTextView.getCompoundDrawables()[1].setColorFilter(this.mContext.getResources().getColor(2131166755), PorterDuff.Mode.MULTIPLY);
      }
      localTextView.setTag(null);
      label187:
      if (!localrkc.equals(this.d)) {
        break label787;
      }
      localTextView.setTextColor(this.mContext.getResources().getColor(2131166755));
    }
    for (;;)
    {
      paramView = (View)localObject1;
      break;
      localTextView = (TextView)paramView;
      localObject1 = paramView;
      break label116;
      label234:
      if (localrkc.musicType == 1)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847532, 0, 0);
        if (localrkc.equals(this.d)) {
          localTextView.getCompoundDrawables()[1].setColorFilter(this.mContext.getResources().getColor(2131166755), PorterDuff.Mode.MULTIPLY);
        }
        localTextView.setTag(null);
        break label187;
      }
      if (localrkc.musicType == 2)
      {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847525, 0, 0);
        if ((this.d != null) && (this.d.musicType == 2)) {
          localTextView.getCompoundDrawables()[1].setColorFilter(this.mContext.getResources().getColor(2131166755), PorterDuff.Mode.MULTIPLY);
        }
        localTextView.setTag(null);
        break label187;
      }
      Resources localResources;
      if (localrkc.musicType == 4)
      {
        paramView = null;
        int i = (int)aqho.convertDpToPixel(this.mContext, 36.0F);
        if (localrkc.imageID > 0)
        {
          paramView = this.mContext.getResources().getDrawable(localrkc.imageID);
          paramView.setBounds(0, 0, i, i);
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
        for (;;)
        {
          if (!localrkc.equals(this.d)) {
            break label682;
          }
          localTextView.getCompoundDrawables()[1].setColorFilter(this.mContext.getResources().getColor(2131166756), PorterDuff.Mode.SRC_ATOP);
          break;
          localResources = this.mContext.getResources();
          for (;;)
          {
            try
            {
              localObject2 = localrkc.aAR;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                continue;
              }
              localFile = new File((String)localObject2);
              if ((!localFile.exists()) || (!localFile.isFile())) {
                continue;
              }
              long l = localFile.length();
              if (l <= 0L) {
                continue;
              }
            }
            catch (Exception paramView)
            {
              Object localObject2;
              File localFile;
              byte[] arrayOfByte;
              View localView;
              paramView = localResources.getDrawable(2130848343);
              continue;
              boolean bool = false;
              continue;
              paramView = localResources.getDrawable(2130848343);
              continue;
              paramView = localResources.getDrawable(2130848343);
              continue;
            }
            try
            {
              arrayOfByte = aqhq.e(localFile);
              localObject2 = paramView;
              if (arrayOfByte != null) {
                localObject2 = Drawable.createFromStream(new ByteArrayInputStream(arrayOfByte), "voiceChangeIcon");
              }
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
              localView = paramView;
            }
          }
          paramView = (View)localObject2;
          if (localObject2 == null)
          {
            paramView = URLDrawable.URLDrawableOptions.obtain();
            paramView.mFailedDrawable = localResources.getDrawable(2130848343);
            paramView.mLoadingDrawable = localResources.getDrawable(2130848343);
            paramView = URLDrawable.getDrawable(localFile, paramView);
            if ("drawable not null: " + paramView == null) {
              break label710;
            }
            bool = true;
            QLog.e("blessVoiceIcon", 1, new Object[] { Boolean.valueOf(bool) });
          }
          paramView.setBounds(0, 0, i, i);
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
        label682:
        break label187;
      }
      label710:
      if (localrkc.equals(this.d)) {
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847527, 0, 0);
      }
      for (;;)
      {
        localTextView.setTag(localrkc);
        break;
        localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130847526, 0, 0);
      }
      label787:
      if ((localrkc.musicType == 2) && (this.d != null) && (this.d.musicType == 2))
      {
        localTextView.setTextColor(this.mContext.getResources().getColor(2131166755));
      }
      else
      {
        localTextView.setTextColor(-1);
        localTextView.getCompoundDrawables()[1].clearColorFilter();
      }
    }
  }
  
  public int ty()
  {
    return this.nF.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rka
 * JD-Core Version:    0.7.0.1
 */