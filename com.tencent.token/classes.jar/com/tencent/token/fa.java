package com.tencent.token;

import java.net.Socket;
import javax.net.ssl.SSLSocket;
import okhttp3.a;
import okhttp3.ab;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.f;
import okhttp3.j;
import okhttp3.k;
import okhttp3.r.a;
import okhttp3.z.a;

public abstract class fa
{
  public static fa a;
  
  public abstract int a(z.a parama);
  
  public abstract Socket a(j paramj, a parama, f paramf);
  
  public abstract c a(j paramj, a parama, f paramf, ab paramab);
  
  public abstract d a(j paramj);
  
  public abstract void a(k paramk, SSLSocket paramSSLSocket, boolean paramBoolean);
  
  public abstract void a(r.a parama, String paramString);
  
  public abstract void a(r.a parama, String paramString1, String paramString2);
  
  public abstract boolean a(a parama1, a parama2);
  
  public abstract boolean a(j paramj, c paramc);
  
  public abstract void b(j paramj, c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fa
 * JD-Core Version:    0.7.0.1
 */