package sit.cp23ms2.sportconnect.tokens;

//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(
//        prePostEnabled = true)
//public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private RestAuthenticationEntryPoint unauthorizedHandler;
//
//    @Autowired
//    private CustomUserDetailsService myUserDetailService;
//
//    @Autowired
//    private JwtRequestFilter jwtRequestFilter;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.userDetailsService(myUserDetailService);
//    }
//
//    @Override
//    public void configure(HttpSecurity security) throws Exception {
//
////        security.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
////                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(new AADB2CJwtBearerTokenAuthenticationConverter());
//
//        security.csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(this.unauthorizedHandler)
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, "/api/users/{id}/**").permitAll()
//                .anyRequest().authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        security.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    public void configure(WebSecurity web)
//            throws Exception {
//        web.ignoring().antMatchers("/api/users");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new Argon2PasswordEncoder();
//    }
//
//    @Bean
//    JwtDecoder jwtDecoder() {
//        return  new CustomJwtDecoder();
//    }
//
//    class CustomJwtDecoder implements JwtDecoder {
//        @Override
//        public Jwt decode(String token) throws JwtException {
//            System.out.println(token);
//            return null;
//        }
//    }
//
//    @Override
//    @Bean
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }
//
//}
