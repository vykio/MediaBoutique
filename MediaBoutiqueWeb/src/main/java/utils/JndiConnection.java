package utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public enum JndiConnection {

    Local, Remote;

    @SuppressWarnings("unchecked")
    public <T> T connect() {

        try {
            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            final Context context = new InitialContext(jndiProperties);

            switch(this) {
                case Local:
                    return (T) context.lookup("java:app/MediaBoutiqueWeb-1.0-SNAPSHOT/MaBootiqueJNDI!ejb.MaBootiqueEJBLocal");
                case Remote:
                    return (T) context.lookup("ejb:MediaBoutique_ear/MediaBoutiqueWeb-1.0-SNAPSHOT/MaBootiqueJNDI!ejb.MaBootiqueEJBRemote");
                default:
                    return null;
            }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}