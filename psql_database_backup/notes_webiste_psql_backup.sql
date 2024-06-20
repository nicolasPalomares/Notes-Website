--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2024-06-20 19:38:54

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4814 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 219 (class 1259 OID 24704)
-- Name: contact; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact (
    contact_id bigint NOT NULL,
    name text,
    number bigint,
    email text
);


ALTER TABLE public.contact OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 24707)
-- Name: contact_contact_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.contact ALTER COLUMN contact_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.contact_contact_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 24716)
-- Name: note; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.note (
    note_id bigint NOT NULL,
    date text,
    "time" text,
    title text,
    content text
);


ALTER TABLE public.note OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 24715)
-- Name: note_note_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.note ALTER COLUMN note_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.note_note_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 24692)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    role_id bigint NOT NULL,
    name text,
    user_id bigint
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 24691)
-- Name: role_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.role ALTER COLUMN role_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.role_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 216 (class 1259 OID 24684)
-- Name: user_entity; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_entity (
    user_id bigint NOT NULL,
    username text,
    password text
);


ALTER TABLE public.user_entity OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24683)
-- Name: user_entity_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.user_entity ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.user_entity_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4805 (class 0 OID 24704)
-- Dependencies: 219
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (9, 'John', 11223344, 'john@mail.com');
INSERT INTO public.contact OVERRIDING SYSTEM VALUE VALUES (10, 'Carla', 55667788, 'carla@mail.com');


--
-- TOC entry 4808 (class 0 OID 24716)
-- Dependencies: 222
-- Data for Name: note; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.note OVERRIDING SYSTEM VALUE VALUES (6, '2024-08-21', '16:00', 'Appointment', 'Appointment with cardiologist');


--
-- TOC entry 4804 (class 0 OID 24692)
-- Dependencies: 218
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role OVERRIDING SYSTEM VALUE VALUES (1, 'ROLE_USER', 1);


--
-- TOC entry 4802 (class 0 OID 24684)
-- Dependencies: 216
-- Data for Name: user_entity; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_entity OVERRIDING SYSTEM VALUE VALUES (1, 'testUser', '$2a$10$Efa.GTxx9GglTt.UrIM09Ovmyi4.fraEKLoDKtBmbshEbhCAshULG');


--
-- TOC entry 4815 (class 0 OID 0)
-- Dependencies: 220
-- Name: contact_contact_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contact_contact_id_seq', 10, true);


--
-- TOC entry 4816 (class 0 OID 0)
-- Dependencies: 221
-- Name: note_note_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.note_note_id_seq', 6, true);


--
-- TOC entry 4817 (class 0 OID 0)
-- Dependencies: 217
-- Name: role_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.role_role_id_seq', 1, true);


--
-- TOC entry 4818 (class 0 OID 0)
-- Dependencies: 215
-- Name: user_entity_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_entity_user_id_seq', 1, true);


--
-- TOC entry 4654 (class 2606 OID 24714)
-- Name: contact contact_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (contact_id);


--
-- TOC entry 4656 (class 2606 OID 24722)
-- Name: note note_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.note
    ADD CONSTRAINT note_pkey PRIMARY KEY (note_id);


--
-- TOC entry 4652 (class 2606 OID 24698)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (role_id);


--
-- TOC entry 4650 (class 2606 OID 24690)
-- Name: user_entity user_entity_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_entity
    ADD CONSTRAINT user_entity_pkey PRIMARY KEY (user_id);


--
-- TOC entry 4657 (class 2606 OID 24699)
-- Name: role user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT user_id_fkey FOREIGN KEY (user_id) REFERENCES public.user_entity(user_id) NOT VALID;


-- Completed on 2024-06-20 19:38:56

--
-- PostgreSQL database dump complete
--

