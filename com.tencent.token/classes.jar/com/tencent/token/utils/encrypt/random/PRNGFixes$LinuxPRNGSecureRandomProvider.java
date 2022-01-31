package com.tencent.token.utils.encrypt.random;

import java.security.Provider;

class PRNGFixes$LinuxPRNGSecureRandomProvider
  extends Provider
{
  public PRNGFixes$LinuxPRNGSecureRandomProvider()
  {
    super("LinuxPRNG", 1.0D, "A Linux-specific random number provider that uses /dev/urandom");
    put("SecureRandom.SHA1PRNG", PRNGFixes.LinuxPRNGSecureRandom.class.getName());
    put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.encrypt.random.PRNGFixes.LinuxPRNGSecureRandomProvider
 * JD-Core Version:    0.7.0.1
 */