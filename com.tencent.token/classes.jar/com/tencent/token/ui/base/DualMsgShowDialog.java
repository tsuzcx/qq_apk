package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.cm;
import com.tencent.token.cn;
import com.tencent.token.co;
import com.tencent.token.core.bean.a;
import com.tencent.token.ek;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.ui.ModifyQQPwdActivity;
import com.tencent.token.ui.o;
import com.tencent.token.utils.UserTask;

public class DualMsgShowDialog
  extends Dialog
{
  private Activity a;
  private DualMsgView b;
  private boolean c = false;
  private int d;
  private int e = 0;
  private boolean f = false;
  private a g = null;
  private long h;
  private int i = 0;
  private Toast j;
  private TextView k;
  
  public DualMsgShowDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    super(paramActivity, paramInt1);
    this.a = paramActivity;
    this.d = paramInt2;
  }
  
  public DualMsgShowDialog(Activity paramActivity, int paramInt1, int paramInt2, boolean paramBoolean, long paramLong)
  {
    super(paramActivity, paramInt1);
    this.a = paramActivity;
    this.d = paramInt2;
    this.f = paramBoolean;
    this.h = paramLong;
  }
  
  private void a(final a parama, final int paramInt)
  {
    if ((this.b == null) || (this.j == null) || (this.k == null)) {
      return;
    }
    if (parama == null)
    {
      this.b.a(paramInt);
      return;
    }
    new UserTask()
    {
      public e a(String... paramAnonymousVarArgs)
      {
        if (DualMsgShowDialog.d(DualMsgShowDialog.this) == 0) {
          return co.a().a(parama, paramInt);
        }
        return cm.a().a(parama, paramInt);
      }
      
      public void a(e paramAnonymouse) {}
    }.c(new String[] { "" });
    g.a("current item index: " + this.e);
    if (paramInt == 2)
    {
      this.k.setText(2131230947);
      this.j.show();
      if (parama.c() == this.h) {
        this.i = -1;
      }
      label121:
      this.e += 1;
      if (this.d != 0) {
        break label264;
      }
    }
    label264:
    for (parama = co.a();; parama = cm.a())
    {
      if (this.e != parama.b()) {
        break label271;
      }
      this.b.a(paramInt);
      if ((paramInt != 3) || (this.d != 0)) {
        break;
      }
      new AlertDialog.Builder(this.a).setTitle(2131230843).setMessage(this.a.getString(2131230951)).setPositiveButton(2131231243, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent(DualMsgShowDialog.b(DualMsgShowDialog.this), ModifyQQPwdActivity.class);
          o.a().a(DualMsgShowDialog.b(DualMsgShowDialog.this), paramAnonymousDialogInterface, o.b);
        }
      }).setNegativeButton(2131230886, null).create().show();
      return;
      this.k.setText(2131230948);
      this.j.show();
      if (parama.c() != this.h) {
        break label121;
      }
      this.i = -2;
      break label121;
    }
    label271:
    c();
    if (this.g == null)
    {
      this.b.a(paramInt);
      return;
    }
    this.b.b(this.g);
  }
  
  private void c()
  {
    if (this.d == 0) {}
    for (this.g = co.a().a(this.e);; this.g = cm.a().a(this.e))
    {
      if ((this.g == null) || (this.g.f() == null) || (this.g.g() == null) || (this.g.h() == null) || (this.g.i() == null))
      {
        g.c("item content err");
        this.g = null;
      }
      return;
    }
  }
  
  private void d()
  {
    new UserTask()
    {
      public e a(String... paramAnonymousVarArgs)
      {
        try
        {
          ek.a("tbl_dual_msg");
          ek.a("tbl_barcode_msg");
          label10:
          return null;
        }
        catch (Error paramAnonymousVarArgs)
        {
          break label10;
        }
        catch (Exception paramAnonymousVarArgs)
        {
          break label10;
        }
      }
    }.equals("");
  }
  
  public void a()
  {
    c();
    if (this.g == null) {
      return;
    }
    this.b.a(this.g);
  }
  
  public void b()
  {
    this.b.a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = new DualMsgView(this.a);
    this.b.setListener(new DualMsgView.f()
    {
      public void a()
      {
        DualMsgShowDialog.this.dismiss();
        if (DualMsgShowDialog.a(DualMsgShowDialog.this))
        {
          Intent localIntent = new Intent(DualMsgShowDialog.b(DualMsgShowDialog.this), IndexActivity.class);
          localIntent.putExtra("intent.retcode", DualMsgShowDialog.c(DualMsgShowDialog.this));
          DualMsgShowDialog.b(DualMsgShowDialog.this).startActivity(localIntent);
        }
      }
      
      public void a(int paramAnonymousInt)
      {
        if (DualMsgShowDialog.d(DualMsgShowDialog.this) == 0) {}
        for (a locala = co.a().a(DualMsgShowDialog.e(DualMsgShowDialog.this));; locala = cm.a().a(DualMsgShowDialog.e(DualMsgShowDialog.this)))
        {
          DualMsgShowDialog.a(DualMsgShowDialog.this, locala, paramAnonymousInt);
          return;
        }
      }
    });
    if (!this.b.a(this.a))
    {
      dismiss();
      g.a("Dual initView failed!");
      return;
    }
    c();
    if (this.g == null)
    {
      dismiss();
      return;
    }
    this.b.a(this.g);
    setContentView(this.b);
    d();
    paramBundle = this.a.getLayoutInflater().inflate(2130968780, null);
    this.j = new Toast(this.a);
    this.j.setView(paramBundle);
    this.j.setDuration(0);
    this.j.setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
    this.k = ((TextView)paramBundle.findViewById(2131558988));
    ((ImageView)paramBundle.findViewById(2131558987)).setBackgroundResource(2130838018);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.g == null)
      {
        dismiss();
        this.c = true;
      }
      if (!this.c)
      {
        this.c = true;
        this.b.b();
      }
    }
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.DualMsgShowDialog
 * JD-Core Version:    0.7.0.1
 */