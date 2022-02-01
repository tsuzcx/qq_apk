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
import com.tencent.token.co;
import com.tencent.token.core.bean.a;
import com.tencent.token.cp;
import com.tencent.token.cq;
import com.tencent.token.en;
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
    Object localObject = this.b;
    if ((localObject != null) && (this.j != null))
    {
      if (this.k == null) {
        return;
      }
      if (parama == null)
      {
        ((DualMsgView)localObject).a(paramInt);
        return;
      }
      new UserTask()
      {
        public e a(String... paramAnonymousVarArgs)
        {
          if (DualMsgShowDialog.d(DualMsgShowDialog.this) == 0) {
            return cq.a().a(parama, paramInt);
          }
          return co.a().a(parama, paramInt);
        }
        
        public void a(e paramAnonymouse) {}
      }.c(new String[] { "" });
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("current item index: ");
      ((StringBuilder)localObject).append(this.e);
      g.a(((StringBuilder)localObject).toString());
      if (paramInt == 2)
      {
        this.k.setText(2131493090);
        this.j.show();
        if (parama.c() == this.h) {
          this.i = -1;
        }
      }
      else
      {
        this.k.setText(2131493091);
        this.j.show();
        if (parama.c() == this.h) {
          this.i = -2;
        }
      }
      this.e += 1;
      if (this.d == 0) {
        parama = cq.a();
      } else {
        parama = co.a();
      }
      if (this.e == parama.b())
      {
        this.b.a(paramInt);
        if ((paramInt == 3) && (this.d == 0)) {
          new AlertDialog.Builder(this.a).setTitle(2131492986).setMessage(this.a.getString(2131493094)).setPositiveButton(2131493386, new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              paramAnonymousDialogInterface = new Intent(DualMsgShowDialog.b(DualMsgShowDialog.this), ModifyQQPwdActivity.class);
              o.a().a(DualMsgShowDialog.b(DualMsgShowDialog.this), paramAnonymousDialogInterface, o.b);
            }
          }).setNegativeButton(2131493029, null).create().show();
        }
      }
      else
      {
        c();
        parama = this.g;
        if (parama == null)
        {
          this.b.a(paramInt);
          return;
        }
        this.b.b(parama);
      }
      return;
    }
  }
  
  private void c()
  {
    if (this.d == 0) {
      this.g = cq.a().a(this.e);
    } else {
      this.g = co.a().a(this.e);
    }
    a locala = this.g;
    if ((locala == null) || (locala.f() == null) || (this.g.g() == null) || (this.g.h() == null) || (this.g.i() == null))
    {
      g.c("item content err");
      this.g = null;
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
          en.a("tbl_dual_msg");
          en.a("tbl_barcode_msg");
          label10:
          return null;
        }
        catch (Exception|Error paramAnonymousVarArgs)
        {
          break label10;
        }
      }
    }.equals("");
  }
  
  public void a()
  {
    c();
    a locala = this.g;
    if (locala == null) {
      return;
    }
    this.b.a(locala);
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
        a locala;
        if (DualMsgShowDialog.d(DualMsgShowDialog.this) == 0) {
          locala = cq.a().a(DualMsgShowDialog.e(DualMsgShowDialog.this));
        } else {
          locala = co.a().a(DualMsgShowDialog.e(DualMsgShowDialog.this));
        }
        DualMsgShowDialog.a(DualMsgShowDialog.this, locala, paramAnonymousInt);
      }
    });
    if (!this.b.a(this.a))
    {
      dismiss();
      g.a("Dual initView failed!");
      return;
    }
    c();
    paramBundle = this.g;
    if (paramBundle == null)
    {
      dismiss();
      return;
    }
    this.b.a(paramBundle);
    setContentView(this.b);
    d();
    paramBundle = this.a.getLayoutInflater().inflate(2131296461, null);
    this.j = new Toast(this.a);
    this.j.setView(paramBundle);
    this.j.setDuration(0);
    this.j.setGravity(55, 0, IndexActivity.S_TITLE_HEIGHT);
    this.k = ((TextView)paramBundle.findViewById(2131166120));
    ((ImageView)paramBundle.findViewById(2131166118)).setBackgroundResource(2131100167);
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