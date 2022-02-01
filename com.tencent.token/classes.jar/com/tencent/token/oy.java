package com.tencent.token;

import android.os.Bundle;

public final class oy
{
  public static final class a
    extends on
  {
    public pa c;
    public int d;
    public String e;
    
    public final int a()
    {
      return 2;
    }
    
    public final void a(Bundle paramBundle)
    {
      super.a(paramBundle);
      pa localpa = this.c;
      Bundle localBundle = new Bundle();
      localBundle.putInt("_wxobject_sdkVer", localpa.a);
      localBundle.putString("_wxobject_title", localpa.b);
      localBundle.putString("_wxobject_description", localpa.c);
      localBundle.putByteArray("_wxobject_thumbdata", localpa.d);
      if (localpa.e != null)
      {
        String str2 = localpa.e.getClass().getName();
        String str1 = str2;
        if (str2 != null) {
          if (str2.length() == 0) {
            str1 = str2;
          } else {
            str1 = str2.replace("com.tencent.mm.opensdk.modelmsg", "com.tencent.mm.sdk.openapi");
          }
        }
        localBundle.putString("_wxobject_identifier_", str1);
        localpa.e.a(localBundle);
      }
      localBundle.putString("_wxobject_mediatagname", localpa.f);
      localBundle.putString("_wxobject_message_action", localpa.g);
      localBundle.putString("_wxobject_message_ext", localpa.h);
      paramBundle.putAll(localBundle);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.d);
      paramBundle.putInt("_wxapi_sendmessagetowx_req_media_type", this.c.a());
      paramBundle.putString("_wxapi_sendmessagetowx_req_use_open_id", this.e);
    }
    
    public final void b(Bundle paramBundle)
    {
      super.b(paramBundle);
      this.c = pa.a.a(paramBundle);
      this.d = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
      this.e = paramBundle.getString("_wxapi_sendmessagetowx_req_use_open_id");
    }
    
    public final boolean b()
    {
      pa localpa = this.c;
      if (localpa == null) {
        return false;
      }
      if ((localpa.e.a() == 6) && (this.d == 2)) {
        ((oz)this.c.e).a = 26214400;
      }
      if ((this.d == 3) && (this.e == null)) {
        return false;
      }
      if ((this.d == 3) && (this.b == null)) {
        return false;
      }
      localpa = this.c;
      if ((localpa.a() == 8) && ((localpa.d == null) || (localpa.d.length == 0))) {
        return false;
      }
      if ((pn.a(localpa.a())) && ((localpa.d == null) || (localpa.d.length > 131072))) {
        return false;
      }
      if ((!pn.a(localpa.a())) && (localpa.d != null) && (localpa.d.length > 65536)) {
        return false;
      }
      if ((localpa.b != null) && (localpa.b.length() > 512)) {
        return false;
      }
      if ((localpa.c != null) && (localpa.c.length() > 1024)) {
        return false;
      }
      if (localpa.e == null) {
        return false;
      }
      if ((localpa.f != null) && (localpa.f.length() > 64)) {
        return false;
      }
      if ((localpa.g != null) && (localpa.g.length() > 2048)) {
        return false;
      }
      if ((localpa.h != null) && (localpa.h.length() > 2048)) {
        return false;
      }
      return localpa.e.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.oy
 * JD-Core Version:    0.7.0.1
 */