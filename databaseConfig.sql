PGDMP      $    0                |            veriTabaniProje    15.5    15.5 3    K           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            L           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            M           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            N           1262    16714    veriTabaniProje    DATABASE     �   CREATE DATABASE "veriTabaniProje" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
 !   DROP DATABASE "veriTabaniProje";
                postgres    false            �            1255    16983    garajgelir()    FUNCTION     h  CREATE FUNCTION public.garajgelir() RETURNS integer
    LANGUAGE plpgsql
    AS $$declare 
	tirbakim integer;
	dorsebakim integer;
	gelir integer;
begin
	select sum(bakimmasraflari)
	into tirbakim
	from tir;
	
	select sum(bakimmasraflari)
	into dorsebakim
	from dorse;
	
	select sum(ucret)
	into gelir
	from yuk;
	
	return (gelir-tirbakim-dorsebakim);
end;$$;
 #   DROP FUNCTION public.garajgelir();
       public          postgres    false            �            1255    16998    yuk_function()    FUNCTION     �   CREATE FUNCTION public.yuk_function() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
begin
	insert into ucret
	values (old.yukno,new.yukagirligi,old.ucret + 500*(new.yukagirligi - old.yukagirligi),old.ucret);
	return new;
end;
$$;
 %   DROP FUNCTION public.yuk_function();
       public          postgres    false            �            1259    16715    calisan    TABLE     �   CREATE TABLE public.calisan (
    calisanno integer NOT NULL,
    ad character varying,
    soyad character varying,
    "maaş" integer,
    garajnumarasi integer
);
    DROP TABLE public.calisan;
       public         heap    postgres    false            �            1259    16736    dorse    TABLE     �   CREATE TABLE public.dorse (
    plaka character varying NOT NULL,
    bakimtarihi character varying,
    bakimmasraflari integer,
    toplamkm integer,
    yukkapasitesi integer
);
    DROP TABLE public.dorse;
       public         heap    postgres    false            �            1259    16966 	   dorsepark    TABLE     _   CREATE TABLE public.dorsepark (
    garajnumarasi integer,
    dorseplaka character varying
);
    DROP TABLE public.dorsepark;
       public         heap    postgres    false            �            1259    16764    garaj    TABLE     �   CREATE TABLE public.garaj (
    garajnumarasi integer NOT NULL,
    dorsekapasitesi integer,
    tirkapasitesi integer,
    adres character varying,
    il character varying NOT NULL,
    "yöneticino" integer
);
    DROP TABLE public.garaj;
       public         heap    postgres    false            �            1259    16809    musteri    TABLE     �   CREATE TABLE public.musteri (
    musterino integer NOT NULL,
    isim character varying,
    soyisim character varying,
    dogumtarihi character varying(10),
    kimlikno character(11)
);
    DROP TABLE public.musteri;
       public         heap    postgres    false            �            1259    16844    musteriister    TABLE     �   CREATE TABLE public.musteriister (
    musterino integer,
    yukno integer,
    teslimalinmatarihi character(10),
    teslimedilmetarihi character(10)
);
     DROP TABLE public.musteriister;
       public         heap    postgres    false            �            1259    16857    tasir    TABLE     �   CREATE TABLE public.tasir (
    yukno integer,
    dorseplaka character varying,
    tirplaka character varying,
    yakitmasraflari real,
    mesafe real
);
    DROP TABLE public.tasir;
       public         heap    postgres    false            �            1259    16729    tir    TABLE     �   CREATE TABLE public.tir (
    plaka character varying NOT NULL,
    bakimtarihi character varying,
    bakimmasraflari integer,
    toplamkm integer,
    soforno integer,
    dorseplaka character varying
);
    DROP TABLE public.tir;
       public         heap    postgres    false            �            1259    16907    tirpark    TABLE     [   CREATE TABLE public.tirpark (
    garajnumarasi integer,
    tirplaka character varying
);
    DROP TABLE public.tirpark;
       public         heap    postgres    false            �            1259    17007    ucret    TABLE     k   CREATE TABLE public.ucret (
    yukno integer,
    yukagirligi real,
    ucret real,
    eskiucret real
);
    DROP TABLE public.ucret;
       public         heap    postgres    false            �            1259    16743    yuk    TABLE     �   CREATE TABLE public.yuk (
    yukno integer NOT NULL,
    yukagirligi real,
    teslimedilecekadres character varying NOT NULL,
    teslimalinacakil character varying NOT NULL,
    teslimalinacakadres character varying,
    ucret real
);
    DROP TABLE public.yuk;
       public         heap    postgres    false            �            1259    17010    yuktasiyanbilgisi    VIEW     m  CREATE VIEW public.yuktasiyanbilgisi AS
 SELECT tasir.yukno,
    tasir.dorseplaka,
    tasir.tirplaka,
    tir.soforno,
    calisan.ad,
    calisan.soyad,
    calisan.garajnumarasi
   FROM ((public.tasir
     JOIN public.tir ON (((tasir.tirplaka)::text = (tir.plaka)::text)))
     JOIN public.calisan ON ((tir.soforno = calisan.calisanno)))
  ORDER BY tasir.yukno;
 $   DROP VIEW public.yuktasiyanbilgisi;
       public          postgres    false    214    221    221    221    215    215    214    214    214            >          0    16715    calisan 
   TABLE DATA           O   COPY public.calisan (calisanno, ad, soyad, "maaş", garajnumarasi) FROM stdin;
    public          postgres    false    214   g?       @          0    16736    dorse 
   TABLE DATA           ]   COPY public.dorse (plaka, bakimtarihi, bakimmasraflari, toplamkm, yukkapasitesi) FROM stdin;
    public          postgres    false    216   �@       G          0    16966 	   dorsepark 
   TABLE DATA           >   COPY public.dorsepark (garajnumarasi, dorseplaka) FROM stdin;
    public          postgres    false    223   KA       B          0    16764    garaj 
   TABLE DATA           h   COPY public.garaj (garajnumarasi, dorsekapasitesi, tirkapasitesi, adres, il, "yöneticino") FROM stdin;
    public          postgres    false    218   �A       C          0    16809    musteri 
   TABLE DATA           R   COPY public.musteri (musterino, isim, soyisim, dogumtarihi, kimlikno) FROM stdin;
    public          postgres    false    219   DB       D          0    16844    musteriister 
   TABLE DATA           `   COPY public.musteriister (musterino, yukno, teslimalinmatarihi, teslimedilmetarihi) FROM stdin;
    public          postgres    false    220   :C       E          0    16857    tasir 
   TABLE DATA           U   COPY public.tasir (yukno, dorseplaka, tirplaka, yakitmasraflari, mesafe) FROM stdin;
    public          postgres    false    221   �C       ?          0    16729    tir 
   TABLE DATA           a   COPY public.tir (plaka, bakimtarihi, bakimmasraflari, toplamkm, soforno, dorseplaka) FROM stdin;
    public          postgres    false    215   +D       F          0    16907    tirpark 
   TABLE DATA           :   COPY public.tirpark (garajnumarasi, tirplaka) FROM stdin;
    public          postgres    false    222   �D       H          0    17007    ucret 
   TABLE DATA           E   COPY public.ucret (yukno, yukagirligi, ucret, eskiucret) FROM stdin;
    public          postgres    false    224   BE       A          0    16743    yuk 
   TABLE DATA           t   COPY public.yuk (yukno, yukagirligi, teslimedilecekadres, teslimalinacakil, teslimalinacakadres, ucret) FROM stdin;
    public          postgres    false    217   zE       �           2606    16721    calisan calisan_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.calisan
    ADD CONSTRAINT calisan_pkey PRIMARY KEY (calisanno);
 >   ALTER TABLE ONLY public.calisan DROP CONSTRAINT calisan_pkey;
       public            postgres    false    214            �           2606    16742    dorse dorse_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.dorse
    ADD CONSTRAINT dorse_pkey PRIMARY KEY (plaka);
 :   ALTER TABLE ONLY public.dorse DROP CONSTRAINT dorse_pkey;
       public            postgres    false    216            �           2606    16770    garaj garaj_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.garaj
    ADD CONSTRAINT garaj_pkey PRIMARY KEY (garajnumarasi);
 :   ALTER TABLE ONLY public.garaj DROP CONSTRAINT garaj_pkey;
       public            postgres    false    218            �           2606    16817    musteri musteri_kimlikno_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.musteri
    ADD CONSTRAINT musteri_kimlikno_key UNIQUE (kimlikno);
 F   ALTER TABLE ONLY public.musteri DROP CONSTRAINT musteri_kimlikno_key;
       public            postgres    false    219            �           2606    16815    musteri musteri_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.musteri
    ADD CONSTRAINT musteri_pkey PRIMARY KEY (musterino);
 >   ALTER TABLE ONLY public.musteri DROP CONSTRAINT musteri_pkey;
       public            postgres    false    219            �           2606    16735    tir tir_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY public.tir
    ADD CONSTRAINT tir_pkey PRIMARY KEY (plaka);
 6   ALTER TABLE ONLY public.tir DROP CONSTRAINT tir_pkey;
       public            postgres    false    215            �           2606    16749    yuk yuk_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY public.yuk
    ADD CONSTRAINT yuk_pkey PRIMARY KEY (yukno);
 6   ALTER TABLE ONLY public.yuk DROP CONSTRAINT yuk_pkey;
       public            postgres    false    217            �           2620    16999    tasir yuk_trigger    TRIGGER     m   CREATE TRIGGER yuk_trigger AFTER UPDATE ON public.tasir FOR EACH ROW EXECUTE FUNCTION public.yuk_function();
 *   DROP TRIGGER yuk_trigger ON public.tasir;
       public          postgres    false    227    221            �           2620    17003    yuk yuk_trigger    TRIGGER     k   CREATE TRIGGER yuk_trigger AFTER UPDATE ON public.yuk FOR EACH ROW EXECUTE FUNCTION public.yuk_function();
 (   DROP TRIGGER yuk_trigger ON public.yuk;
       public          postgres    false    217    227            �           2606    16927 "   calisan calisan_garajnumarasi_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.calisan
    ADD CONSTRAINT calisan_garajnumarasi_fkey FOREIGN KEY (garajnumarasi) REFERENCES public.garaj(garajnumarasi);
 L   ALTER TABLE ONLY public.calisan DROP CONSTRAINT calisan_garajnumarasi_fkey;
       public          postgres    false    214    218    3227            �           2606    16976 #   dorsepark dorsepark_dorseplaka_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.dorsepark
    ADD CONSTRAINT dorsepark_dorseplaka_fkey FOREIGN KEY (dorseplaka) REFERENCES public.dorse(plaka) ON DELETE CASCADE;
 M   ALTER TABLE ONLY public.dorsepark DROP CONSTRAINT dorsepark_dorseplaka_fkey;
       public          postgres    false    3223    216    223            �           2606    16971 &   dorsepark dorsepark_garajnumarasi_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.dorsepark
    ADD CONSTRAINT dorsepark_garajnumarasi_fkey FOREIGN KEY (garajnumarasi) REFERENCES public.garaj(garajnumarasi) ON DELETE CASCADE;
 P   ALTER TABLE ONLY public.dorsepark DROP CONSTRAINT dorsepark_garajnumarasi_fkey;
       public          postgres    false    3227    223    218            �           2606    16922    garaj garaj_yöneticino_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.garaj
    ADD CONSTRAINT "garaj_yöneticino_fkey" FOREIGN KEY ("yöneticino") REFERENCES public.calisan(calisanno);
 H   ALTER TABLE ONLY public.garaj DROP CONSTRAINT "garaj_yöneticino_fkey";
       public          postgres    false    218    3219    214            �           2606    16847 (   musteriister musteriister_musterino_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musteriister
    ADD CONSTRAINT musteriister_musterino_fkey FOREIGN KEY (musterino) REFERENCES public.musteri(musterino);
 R   ALTER TABLE ONLY public.musteriister DROP CONSTRAINT musteriister_musterino_fkey;
       public          postgres    false    3231    220    219            �           2606    16852 $   musteriister musteriister_yukno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.musteriister
    ADD CONSTRAINT musteriister_yukno_fkey FOREIGN KEY (yukno) REFERENCES public.yuk(yukno);
 N   ALTER TABLE ONLY public.musteriister DROP CONSTRAINT musteriister_yukno_fkey;
       public          postgres    false    217    220    3225            �           2606    16867    tasir tasir_dorseplaka_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tasir
    ADD CONSTRAINT tasir_dorseplaka_fkey FOREIGN KEY (dorseplaka) REFERENCES public.dorse(plaka);
 E   ALTER TABLE ONLY public.tasir DROP CONSTRAINT tasir_dorseplaka_fkey;
       public          postgres    false    216    3223    221            �           2606    16872    tasir tasir_tirplaka_fkey    FK CONSTRAINT     z   ALTER TABLE ONLY public.tasir
    ADD CONSTRAINT tasir_tirplaka_fkey FOREIGN KEY (tirplaka) REFERENCES public.tir(plaka);
 C   ALTER TABLE ONLY public.tasir DROP CONSTRAINT tasir_tirplaka_fkey;
       public          postgres    false    215    221    3221            �           2606    16862    tasir tasir_yukno_fkey    FK CONSTRAINT     t   ALTER TABLE ONLY public.tasir
    ADD CONSTRAINT tasir_yukno_fkey FOREIGN KEY (yukno) REFERENCES public.yuk(yukno);
 @   ALTER TABLE ONLY public.tasir DROP CONSTRAINT tasir_yukno_fkey;
       public          postgres    false    217    221    3225            �           2606    16937    tir tir_dorseplaka_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.tir
    ADD CONSTRAINT tir_dorseplaka_fkey FOREIGN KEY (dorseplaka) REFERENCES public.dorse(plaka);
 A   ALTER TABLE ONLY public.tir DROP CONSTRAINT tir_dorseplaka_fkey;
       public          postgres    false    3223    215    216            �           2606    16932    tir tir_soforno_fkey    FK CONSTRAINT     |   ALTER TABLE ONLY public.tir
    ADD CONSTRAINT tir_soforno_fkey FOREIGN KEY (soforno) REFERENCES public.calisan(calisanno);
 >   ALTER TABLE ONLY public.tir DROP CONSTRAINT tir_soforno_fkey;
       public          postgres    false    214    215    3219            �           2606    16912 "   tirpark tirpark_garajnumarasi_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tirpark
    ADD CONSTRAINT tirpark_garajnumarasi_fkey FOREIGN KEY (garajnumarasi) REFERENCES public.garaj(garajnumarasi);
 L   ALTER TABLE ONLY public.tirpark DROP CONSTRAINT tirpark_garajnumarasi_fkey;
       public          postgres    false    3227    222    218            �           2606    16917    tirpark tirpark_tirplaka_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY public.tirpark
    ADD CONSTRAINT tirpark_tirplaka_fkey FOREIGN KEY (tirplaka) REFERENCES public.tir(plaka);
 G   ALTER TABLE ONLY public.tirpark DROP CONSTRAINT tirpark_tirplaka_fkey;
       public          postgres    false    215    222    3221            >   +  x^E�KO�0�ϳ?�y�qm�E�$J+!.�tI�9i��{�P_,};�N�W�b܏`y�V�YRx��{nL)��\Q����QJVb���{>��#�+�X{���J�k}��,�3�:��i�i����FXz��vb"��F.�-���dL��o�Ǩ��4����4[,�4C�)���\�ac�'�&���iJ*��7c��!��T��>k���ןEA*��T2^L?��g�
,����B����GxvN�M�cR�Ф����;h'���T��[�)֧J��ݖ}5W�yGD���z�      @   �   x^U��� ߢ
W�$��_�鿎�a�23��T���{0H������Y!�j�B�HB�V*S���ILa_)%Ɠ���anUeVq�J��߼�0���d�VyʢͿ�鶅������Gٲ�ė�bTj٦�������{�����EZ      G   @   x^3�41Q��	Q00�2���L�l#.S8ۘ��6�2��M���l3$qs$��!\�%W� �      B   �   x^=�K
�@D�U����gA�� ��I�q/��;���7�T�
���bĽ!#d� קU1F�p������i�,�w[�0E��'F{)=�s�y�s�񾙆~_�G?"g��B�Yz��{�`��>�{�JV���o'�?Ѣ,      C   �   x^M��j�0E�w>��#��e
�&�E6�[QYJ'i���K�f;�s�C��y�{��o�b��Z1��!�Wug�L�A��L['��	C2蜟l�+���R%Hbk�:�d�iխ���Iڠ�W��c��s _d��6T�Ý�M�6�4�?"�������;�]�}��XQWK9��f�8�8���q2�U�]0]�ZRx����܃�P�T�(ҏ_�m����B�i�|"�_��Y�      D   q   x^U���0�PL,�gzI�uķ��G3��@�ѩ:�uj����l���b0hqU�����c m�~4[&Fľ`�j|���C-#C�ٶg��|{Z|�፻o�=�6{���#�,�      E   `   x^EϹ�0�خ�
����2B��K��H/�j=��9,�����bL�8W�Run0���aJ�y����)Mg���aJy�\�S��Z��1��-9�      ?   �   x^M���0�7��Ā ��_�鿎`�s�^��rs�f����2Ib�cWV#���0	'I��8������է�J2��A�+~z��3��?����z�I�*��Ă���@��p!q8�8W�Y_�����JY<��;|�?��xn�רּ�Px���zl��<r��|�n�-���بu2<�߫��.�Y      F   @   x^3�41Q��	Q�4�2���L�l#.S8ۘ��6�2��M���l3$qs$��!\�%W� ��v      H   (   x^3�44�44 �e�9M|sN#�#�TA� �g      A   �   x^]�=�0Fg�0�)���HC�X>D��`P��e��CFR� գ��=;�<�J����
ցHf��&¹��&XDX���� /W���p����M�PAU?�/�)/B&�O�5ɂ��X�St�Ign�Lr�з`ۼ�'v1�gY�'�GR�:^VB�/[�Lw     