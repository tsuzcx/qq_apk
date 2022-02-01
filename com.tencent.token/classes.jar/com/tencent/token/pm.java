package com.tencent.token;

import android.os.Bundle;

public final class pm
{
  public static final class a
    extends pb
  {
    public po c;
    public int d;
    public String e;
    
    public final int a()
    {
      return 2;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      po localpo = this.c;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_wxobject_sdkVer", localpo.a);
      localBundle.putString("_wxobject_title", localpo.b);
      localBundle.putString("_wxobject_description", localpo.c);
      localBundle.putByteArray("_wxobject_thumbdata", localpo.d);
      if (localpo.e != null)
      {
        String str2 = localpo.e.getClass().getName();
        String str1 = str2;
        if (str2 != null) {
          if (str2.length() == 0) {
            str1 = str2;
          } else {
            str1 = str2.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
          }
        }
        localBundle.putString("_wxobject_identifier_", str1);
        localpo.e.a(localBundle);
      }
      localBundle.putString("_wxobject_mediatagname", localpo.f);
      localBundle.putString("_wxobject_message_action", localpo.g);
      localBundle.putString("_wxobject_message_ext", localpo.h);
      paramBundle.putAll(localBundle);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.d);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.c.a());
      paramBundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.e);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = po.a.a(paramBundle);
      this.d = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
      this.e = paramBundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
    }
    
    public final boolean b()
    {
      po localpo = this.c;
      if (localpo == null) {
        return false;
      }
      if ((localpo.e.a() == 6) && (this.d == 2)) {
        ((pn)this.c.e).a = 26214400;
      }
      if ((this.d == 3) && (this.e == null)) {
        return false;
      }
      if ((this.d == 3) && (this.b == null)) {
        return false;
      }
      localpo = this.c;
      if ((localpo.a() == 8) && ((localpo.d == null) || (localpo.d.length == 0))) {
        return false;
      }
      if ((qb.a(localpo.a())) && ((localpo.d == null) || (localpo.d.length > 131072))) {
        return false;
      }
      if ((!qb.a(localpo.a())) && (localpo.d != null) && (localpo.d.length > 65536)) {
        return false;
      }
      if ((localpo.b != null) && (localpo.b.length() > 512)) {
        return false;
      }
      if ((localpo.c != null) && (localpo.c.length() > 1024)) {
        return false;
      }
      if (localpo.e == null) {
        return false;
      }
      if ((localpo.f != null) && (localpo.f.length() > 64)) {
        return false;
      }
      if ((localpo.g != null) && (localpo.g.length() > 2048)) {
        return false;
      }
      if ((localpo.h != null) && (localpo.h.length() > 2048)) {
        return false;
      }
      return localpo.e.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pm
 * JD-Core Version:    0.7.0.1
 */