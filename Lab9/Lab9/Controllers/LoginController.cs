using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Lab9.Models;
namespace Lab9.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Authorise(User user)
        {
            using(DbModels db = new DbModels())
            {
                var userDetail = db.Users.Where(x => x.name == user.name && x.password == user.password).FirstOrDefault();
                if(userDetail == null)
                {
                    user.LoginErrorMessage = "Invalid user";
                    return View("Index", user);
                }
                else
                {
                    Session["userName"] = user.name;
                    return RedirectToAction("Index", "Home");
                }
            }
        }

        public ActionResult LogOut()
        {
            Session.Abandon();
            return RedirectToAction("Index", "Login");
        }
    }
}