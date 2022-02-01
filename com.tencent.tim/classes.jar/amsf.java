import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;

public class amsf
  extends amtl
{
  private amsf.a a;
  protected Set<String> ac;
  
  public amsf(aqdf paramaqdf)
  {
    super(paramaqdf);
  }
  
  public amsf(aqdf paramaqdf, amsf.a parama)
  {
    super(paramaqdf);
    this.a = parama;
  }
  
  public amsf(aqdf paramaqdf, amsf.a parama, Set<String> paramSet)
  {
    super(paramaqdf);
    this.a = parama;
    this.ac = paramSet;
  }
  
  private void L(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_entrance", 29);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SelectMemberActivity.a(paramString, "", 0, paramString));
    localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
    paramActivity.startActivityForResult(localIntent, 1300);
  }
  
  public void a(ampx paramampx, amxy paramamxy, Bitmap paramBitmap)
  {
    if (paramampx.pG() == 103)
    {
      if (paramamxy.w() != null) {
        paramamxy.w().setImageDrawable(amxk.e(paramBitmap));
      }
      return;
    }
    super.a(paramampx, paramamxy, paramBitmap);
  }
  
  public void b(ampx paramampx, amxy paramamxy)
  {
    super.b(paramampx, paramamxy);
    Object localObject;
    if (((paramampx instanceof amor)) && (paramampx.getDescription() == null))
    {
      if (paramamxy.N() != null) {
        paramamxy.N().setVisibility(8);
      }
      if (paramamxy.getTitleView() != null) {
        paramamxy.getTitleView().setVisibility(8);
      }
      if (paramamxy.z() != null) {
        paramamxy.z().setVisibility(8);
      }
      localObject = ((amxs)paramamxy).S();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramampx.getTitle());
      }
      localObject = paramamxy.getView().findViewById(2131380904);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((paramampx instanceof amom)) || ((paramampx instanceof amoq)) || ((paramampx instanceof amok))) && (amkl.gM(paramampx.getUin()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (paramamxy.N() != null)
      {
        localObject = paramampx.getUin();
        if ((this.ac != null) && (this.ac.contains(localObject))) {
          paramamxy.N().setText(acfp.m(2131704476));
        }
      }
      if ((amxk.cEt) && (paramamxy.getView() != null) && ((paramampx instanceof ampt))) {
        paramamxy.getView().setOnLongClickListener(new amsg(this, paramampx));
      }
      if ((paramamxy.v() != null) && ((paramampx instanceof amok)))
      {
        int i = ((amok)paramampx).sZ();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          paramamxy = paramamxy.v();
          paramamxy.setContentDescription(paramamxy.getContext().getString(2131701589));
          paramamxy.setImageResource(2130846928);
          paramamxy.setOnClickListener(new amsh(this, paramampx));
        }
      }
      return;
    }
    if ((paramamxy.N() != null) && (!TextUtils.isEmpty(paramampx.getDescription())))
    {
      paramamxy.N().setVisibility(0);
      label411:
      if (paramamxy.getTitleView() != null) {
        paramamxy.getTitleView().setVisibility(0);
      }
      if ((paramamxy.z() == null) || (paramampx.f() == null)) {
        break label667;
      }
      paramamxy.z().setVisibility(0);
      if ((!(paramampx instanceof amok)) && (!(paramampx instanceof amoj)) && (!(paramampx instanceof amoo))) {
        break label651;
      }
      localObject = paramampx.getUin();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!aqft.rj((String)localObject))) {
        break label635;
      }
      localObject = paramamxy.z().getContext().getResources().getDrawable(2130842599);
      ((Drawable)localObject).setBounds(0, 0, wja.dp2px(15.0F, paramamxy.z().getContext().getResources()), wja.dp2px(15.0F, paramamxy.z().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      paramamxy.z().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((amxs)paramamxy).S();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (paramamxy.N() == null) {
        break label411;
      }
      paramamxy.N().setVisibility(8);
      break label411;
      label635:
      paramamxy.z().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      paramamxy.z().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (paramamxy.z() != null) {
        paramamxy.z().setVisibility(8);
      }
    }
  }
  
  protected void c(ampx paramampx, amxy paramamxy)
  {
    if (this.a != null)
    {
      if (paramamxy.getView() != null) {
        paramamxy.getView().setOnClickListener(new amsi(this));
      }
      return;
    }
    super.c(paramampx, paramamxy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amsf
 * JD-Core Version:    0.7.0.1
 */