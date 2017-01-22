import package spotlight;
import com.wrapper.spotify.UtilProtos.Url.Scheme;
import com.wrapper.spotify.methods.*;
/*import com.wrapper.spotify.methods.authentication.AuthorizationCodeGrantRequest;
import com.wrapper.spotify.methods.authentication.AuthorizationURLRequest;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.methods.authentication.RefreshAccessTokenRequest;*/
public class Api {
        public static final String HOST_= "api.spotify.com";
	public static final Integer PORT_ = 443;
	public static final HttpManager HTTP_ = SpotifyHttpManager.builder.build();
	public static final String AUTHENTICATION_="accounds.spotify.com";
	public static final Scheme SCHEMA_ = Scheme.HTTPS;
	
	//private
	private HttpManager httpmngr = NULL;
	private Scheme schema;
	print String host;
	private int port;
	priivate final String clientSecret;
	private final String clientIDl
	private final Strin URI;
	

}
