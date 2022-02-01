import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;

public class axim
{
  private final int eFh = 10;
  
  private axim()
  {
    anpl.start();
  }
  
  public static axim a()
  {
    return axim.a.b();
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if (paramHashMap == null)
    {
      b(paramString, axip.a().aj(), paramBoolean);
      return;
    }
    b(paramString, axio.a(axip.a().aj(), paramHashMap), paramBoolean);
  }
  
  private void b(String paramString, HashMap<String, String> paramHashMap, boolean paramBoolean)
  {
    if ((axip.a().aOH()) || (paramBoolean)) {
      UserAction.onUserAction(paramString, true, -1L, -1L, paramHashMap, true, false);
    }
  }
  
  private void q(String paramString, HashMap<String, String> paramHashMap)
  {
    a(paramString, paramHashMap, false);
  }
  
  public void Yk(boolean paramBoolean)
  {
    if (axio.uU())
    {
      q("performance#camera_app#res_ready", axip.a().a(paramBoolean));
      axio.aoV();
    }
  }
  
  public void a(String paramString1, boolean paramBoolean, float paramFloat, double paramDouble1, double paramDouble2, String paramString2)
  {
    q("performance#camera_app#video", axip.a().a(paramString1, paramBoolean, paramFloat, paramDouble1, paramDouble2, paramString2));
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    a("performance#camera_app#res_download", axip.a().a(paramBoolean, paramInt, paramString1, paramString2, paramLong1, paramLong2), true);
  }
  
  public void aQ(long paramLong1, long paramLong2)
  {
    q("performance#camera_app#cost_time", axip.a().a(paramLong1, paramLong2));
  }
  
  public void acI(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    q("click#shoot_edit#post_btn", axip.a().E(paramString));
  }
  
  public void acJ(String paramString)
  {
    q("click#shoot_edit#filter_item", axip.a().F(paramString));
  }
  
  public void acK(String paramString)
  {
    q("click#shoot_view#face_item", axip.a().A(paramString));
  }
  
  public void acL(String paramString)
  {
    q("click#shoot_view#filter_ai", axip.a().B(paramString));
  }
  
  public void acM(String paramString)
  {
    q("click#shoot_view#filter_item", axip.a().C(paramString));
  }
  
  public void acN(String paramString)
  {
    q("expose#shoot_view#face_item", axip.a().D(paramString));
  }
  
  public void acO(String paramString)
  {
    q("click#emoticon_edit#text_ai", axip.a().I(paramString));
  }
  
  public void acP(String paramString)
  {
    q("expose#emoticon_edit#emoticon_item", axip.a().G(paramString));
  }
  
  public void acQ(String paramString)
  {
    q("click#emoticon_view#filter_item", axip.a().H(paramString));
  }
  
  public void adV(int paramInt)
  {
    q("click#shoot_edit#pick_done", axip.a().e(paramInt));
  }
  
  public void adW(int paramInt)
  {
    q("click#shoot_edit#edit_done", axip.a().d(paramInt));
  }
  
  public void bJ(String paramString, long paramLong)
  {
    q("performance#camera_app#material2screen", axip.a().i(paramString, paramLong));
  }
  
  public void e(String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2)
  {
    q("performance#camera_app#material_zip_download", axip.a().a(paramString1, paramInt, paramLong1, paramLong2, paramString2));
  }
  
  public void eKA()
  {
    q("enter#shoot_edit#view", axip.a().ao());
  }
  
  public void eKB()
  {
    q("click#shoot_edit#post_btn", axip.a().ap());
  }
  
  public void eKC()
  {
    q("click#shoot_edit#rephoto_btn", null);
  }
  
  public void eKD()
  {
    q("click#shoot_edit#video_edit", axip.a().ak());
  }
  
  public void eKE()
  {
    q("click#shoot_edit#text_edit", axip.a().ak());
  }
  
  public void eKF()
  {
    q("click#shoot_edit#preview_btn", axip.a().ak());
  }
  
  public void eKG()
  {
    q("click#shoot_edit#pic_switch", axip.a().ak());
  }
  
  public void eKH()
  {
    q("click#shoot_edit#edit_done", axip.a().aq());
  }
  
  public void eKI()
  {
    q("click#shoot_edit#text_btn", axip.a().ar());
  }
  
  public void eKJ()
  {
    q("click#shoot_edit#music_btn", axip.a().as());
  }
  
  public void eKK()
  {
    q("click#shoot_edit#cut_btn", null);
  }
  
  public void eKL()
  {
    q("click#shoot_edit#apply_btn", axip.a().as());
  }
  
  public void eKM()
  {
    q("click#shoot_edit#music_item", axip.a().at());
  }
  
  public void eKN()
  {
    q("expose#shoot_view#view", null);
  }
  
  public void eKO()
  {
    q("click#shoot_view#cancel_btn", null);
  }
  
  public void eKP()
  {
    q("click#shoot_view#local_btn", null);
  }
  
  public void eKQ()
  {
    q("click#shoot_view#flash_btn", null);
  }
  
  public void eKR()
  {
    q("click#shoot_view#switch_btn", null);
  }
  
  public void eKS()
  {
    q("click#shoot_view#face_btn", null);
  }
  
  public void eKT()
  {
    q("click#shoot_view#photo_switch", null);
  }
  
  public void eKU()
  {
    q("click#shoot_view#emoticon_switch", null);
  }
  
  public void eKV()
  {
    q("click#shoot_view#module_btn", null);
  }
  
  public void eKW()
  {
    q("click#shoot_view#make_btn", axip.a().ak());
  }
  
  public void eKX()
  {
    q("click#shoot_view#photo_make", axip.a().ak());
  }
  
  public void eKY()
  {
    q("click#shoot_view#now_make", axip.a().ak());
  }
  
  public void eKZ()
  {
    q("click#shoot_view#banner_icon", axip.a().an());
  }
  
  public void eKz()
  {
    q("expose#shoot_edit#view", null);
  }
  
  public void eLa()
  {
    q("expose#shoot_view#banner_icon", axip.a().an());
  }
  
  public void eLb()
  {
    q("click#shoot_view#play_switch", null);
  }
  
  public void eLc()
  {
    q("click#shoot_view#next_btn", axip.a().al());
  }
  
  public void eLd()
  {
    q("click#shoot_view#face_outbtn", null);
  }
  
  public void eLe()
  {
    q("click#shoot_view#done_btn", axip.a().am());
  }
  
  public void eLf()
  {
    q("click#shoot_view#rephoto_btn", axip.a().am());
  }
  
  public void eLg()
  {
    q("click#transmit_view#cancel_btn", axip.a().au());
  }
  
  public void eLh()
  {
    q("expose#camera_app#view", null);
  }
  
  public void eLi()
  {
    q("performance#camera_app#shader", axip.a().aw());
  }
  
  public void eLj()
  {
    q("expose#basics_view#pic_view", null);
  }
  
  public void eLk()
  {
    q("expose#basics_view#photo_view", null);
  }
  
  public void eLl()
  {
    q("click#emoticon_view#photo_btn", axip.a().ay());
  }
  
  public void eLm()
  {
    q("click#emoticon_view#emoticon_item", axip.a().az());
  }
  
  public void eLn()
  {
    q("enter#emoticon_edit#view", axip.a().ax());
  }
  
  public void eLo()
  {
    q("click#emoticon_edit#save_btn", axip.a().aA());
  }
  
  public void eLp()
  {
    q("click#emoticon_edit#send_btn", axip.a().aA());
  }
  
  public void eLq()
  {
    q("click#emoticon_edit#save_btn", axip.a().aB());
  }
  
  public void hg(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    q("click#shoot_edit#post_btn", axip.a().a(paramString, paramInt));
  }
  
  public void l(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    q("performance#camera_app#server", axip.a().a(paramInt1, paramString1, paramString2, paramInt2));
  }
  
  public void nZ(long paramLong)
  {
    q("enter#shoot_view#view", axip.a().a(paramLong));
  }
  
  public void o(Long paramLong)
  {
    q("click#transmit_view#receiver", axip.a().a(paramLong));
  }
  
  public void oa(long paramLong)
  {
    q("click#shoot_view#photo_btn", axip.a().b(paramLong));
  }
  
  public void reportLaunch()
  {
    if (axip.a().aOJ())
    {
      q("performance#camera_app#launch", axip.a().av());
      axip.a().eLv();
    }
  }
  
  static class a
  {
    private static axim a = new axim(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axim
 * JD-Core Version:    0.7.0.1
 */